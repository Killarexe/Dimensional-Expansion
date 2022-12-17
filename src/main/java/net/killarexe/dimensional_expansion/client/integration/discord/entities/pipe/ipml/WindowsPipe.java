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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import net.killarexe.dimensional_expansion.client.integration.discord.IPCClient;
import net.killarexe.dimensional_expansion.client.integration.discord.entities.Callback;
import net.killarexe.dimensional_expansion.client.integration.discord.entities.Packet;
import net.killarexe.dimensional_expansion.client.integration.discord.entities.pipe.Pipe;
import net.killarexe.dimensional_expansion.client.integration.discord.entities.pipe.PipeStatus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

import javax.json.JsonException;

public class WindowsPipe extends Pipe
{

    private static final Logger LOGGER = LoggerFactory.getLogger(WindowsPipe.class);

    private final RandomAccessFile file;

    public WindowsPipe(IPCClient ipcClient, HashMap<String, Callback> callbacks, String location)
    {
        super(ipcClient, callbacks);
        try {
            this.file = new RandomAccessFile(location, "rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write(byte[] b) throws IOException {
        file.write(b);
    }

    @Override
    public Packet read() throws IOException, JsonException {
        while(file.length() == 0 && status == PipeStatus.CONNECTED)
        {
            try {
                Thread.sleep(50);
            } catch(InterruptedException ignored) {}
        }

        if(status == PipeStatus.DISCONNECTED)
            throw new IOException("Disconnected!");

        if(status == PipeStatus.CLOSED)
            return new Packet(Packet.OpCode.CLOSE, null);

        Packet.OpCode op = Packet.OpCode.values()[Integer.reverseBytes(file.readInt())];
        int len = Integer.reverseBytes(file.readInt());
        byte[] d = new byte[len];

        file.readFully(d);
        Packet p = new Packet(op, new Gson().fromJson(new String(d), JsonObject.class));
        LOGGER.debug(String.format("Received packet: %s", p.toString()));
        if(listener != null)
            listener.onPacketReceived(ipcClient, p);
        return p;
    }

    @Override
    public void close() throws IOException {
        LOGGER.debug("Closing IPC pipe...");
        send(Packet.OpCode.CLOSE, new JsonObject(), null);
        status = PipeStatus.CLOSED;
        file.close();
    }

}