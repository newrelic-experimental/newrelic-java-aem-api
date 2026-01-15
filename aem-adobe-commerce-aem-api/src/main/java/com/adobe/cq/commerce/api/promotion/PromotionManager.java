package com.adobe.cq.commerce.api.promotion;

import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type = MatchType.Interface)
public class PromotionManager {

	@Trace
	public List<Promotion> getAvailablePromotions(ResourceResolver var1) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AEM","PromotionManager",getClass().getSimpleName(),"getAvailablePromotions");
		return Weaver.callOriginal();
	}

	@Trace
	public Voucher findVoucher(SlingHttpServletRequest var1, String var2) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AEM","PromotionManager",getClass().getSimpleName(),"findVoucher");
		return Weaver.callOriginal();
	}

}
