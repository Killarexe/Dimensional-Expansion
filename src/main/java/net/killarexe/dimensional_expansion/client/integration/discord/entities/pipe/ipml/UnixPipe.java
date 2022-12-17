/*
 * Copyright 2017 John Grosh (john.a.grosh@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.killarexe.dimensional_expansion.client.integration.discord.entities.pipe.ipml;

import org.newsclub.net.unix.AFUNIXSocket;
import org.newsclub.net.unix.AFUNIXSocketAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import net.killarexe.dimensional_expansion.client.integration.discord.IPCClient;
import net.killarexe.dimensional_expansion.client.integration.discord.entities.Callback;
import net.killarexe.dimensional_expansion.client.integration.discord.entities.Packet;
import net.killarexe.dimensional_expansion.client.integration.discord.entities.pipe.Pipe;
import net.killarexe.dimensional_expansion.client.integration.discord.entities.pipe.PipeStatus;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;

import javax.json.JsonException;

public class UnixPipe extends Pipe
{

    private static final Logger LOGGER = LoggerFactory.getLogger(UnixPipe.class);
    private final AFUNIXSocket socket;

    @SuppressWarnings("deprecation")
	public UnixPipe(IPCClient ipcClient, HashMap<String, Callback> callbacks, String location) throws IOException
    {
        super(ipcClient, callbacks);
        LOGGER.info("CONNECTING...");
        socket = AFUNIXSocket.newInstance();
        socket.connect(new AFUNIXSocketAddress(new File(location)));
        LOGGER.info("CONNECTED!");
    }

    @Override
    public Packet read() throws IOException, JsonException
    {
        InputStream is = socket.getInputStream();

        while(is.available() == 0 && status == PipeStatus.CONNECTED)
        {
            try {
                Thread.sleep(50);
            } catch(InterruptedException ignored) {}
        }

        /*byte[] buf = new byte[is.available()];
        is.read(buf, 0, buf.length);
        LOGGER.info(new String(buf));

        if (true) return null;*/

        if(status==PipeStatus.DISCONNECTED)
            throw new IOException("Disconnected!");

        if(status==PipeStatus.CLOSED)
            return new Packet(Packet.OpCode.CLOSE, null);

        // Read the op and length. Both are signed ints
        byte[] d = new byte[8];
        is.read(d);
        ByteBuffer bb = ByteBuffer.wrap(d);

        Packet.OpCode op = Packet.OpCode.values()[Integer.reverseBytes(bb.getInt())];
        d = new byte[Integer.reverseBytes(bb.getInt())];

        is.read(d);
        Packet p = new Packet(op, new Gson().fromJson(new String(d), JsonObject.class));
        LOGGER.debug(String.format("Received packet: %s", p.toString()));
        if(listener != null)
            listener.onPacketReceived(ipcClient, p);
        return p;
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        socket.getOutputStream().write(b);
    }

    @Override
    public void close() throws IOException
    {
        LOGGER.debug("Closing IPC pipe...");
        send(Packet.OpCode.CLOSE, new JsonObject(), null);
        status = PipeStatus.CLOSED;
        socket.close();
    }
}