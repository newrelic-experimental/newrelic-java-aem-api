package com.day.cq.dam.api;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type = MatchType.Interface)
public abstract class Processor {

	@Trace
	public void process(byte[] var1, int var2, int var3) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AEM","Day","Processor",getClass().getSimpleName(),"process");
		Weaver.callOriginal();
	}
}
