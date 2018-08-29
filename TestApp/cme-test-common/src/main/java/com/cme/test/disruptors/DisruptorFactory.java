package com.cme.test.disruptors;

import java.util.concurrent.ThreadFactory;

import com.cme.test.events.MessageMetadata;
import com.cme.test.events.MessagePublish;
import com.lmax.disruptor.dsl.Disruptor;

public class DisruptorFactory<T> {

	@SuppressWarnings("unchecked")
	public Disruptor<T> getDisruptor(Class<T> event, int ringBufferSize,
			ThreadFactory threadFactory) {

		if (event.equals(MessageMetadata.class)) {
			return (Disruptor<T>) new Disruptor<>(MessageMetadata::new,
					ringBufferSize, threadFactory);
		}
		if(event.equals(MessagePublish.class)) {
			return (Disruptor<T>) new Disruptor<>(MessagePublish::new,
					ringBufferSize, threadFactory);
		}

		return null;
	}
}
