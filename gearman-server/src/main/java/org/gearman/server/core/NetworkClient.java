package org.gearman.server.core;

import org.gearman.common.interfaces.Client;
import org.gearman.common.packets.Packet;
import org.gearman.common.packets.response.WorkResponse;
import org.gearman.common.Job;
import org.jboss.netty.channel.Channel;

public class NetworkClient implements Client {
    private final Channel channel;
    private Job currentJob;

    public NetworkClient(Channel channel)
    {
        this.channel = channel;
    }

    @Override
    public Job getCurrentJob() {
        return currentJob;
    }

    @Override
    public void setCurrentJob(Job job) {
        this.currentJob = job;
    }

    public void send(Packet packet)
    {
        channel.write(packet);
    }

    public void send(WorkResponse packet) {
        channel.write(packet);
    }
}
