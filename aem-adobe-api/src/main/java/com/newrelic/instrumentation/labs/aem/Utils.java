package com.newrelic.instrumentation.labs.aem;

import java.util.Map;

import com.day.cq.dam.api.Asset;

public class Utils {

	public static void addAttribute(Map<String, Object> attributes, String key, Object value) {
		
		if(attributes != null && key != null && !key.isEmpty() && value != null) {
			attributes.put(key, value);
		}
	}
	
	public static void addAsset(Map<String, Object> attributes, Asset asset) {
		if(asset != null) {
			addAttribute(attributes, "Asset-Name", asset.getName());
			addAttribute(attributes, "Asset-Path", asset.getPath());
			addAttribute(attributes, "Asset-MimeType", asset.getMimeType());
		}
		
	}
}
