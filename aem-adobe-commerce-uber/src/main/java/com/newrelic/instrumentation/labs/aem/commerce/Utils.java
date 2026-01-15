package com.newrelic.instrumentation.labs.aem.commerce;

import java.util.Map;

import com.adobe.cq.commerce.api.Product;
import com.adobe.cq.commerce.api.promotion.Promotion;
import com.day.cq.wcm.api.Page;

public class Utils {

	public static void addAttribute(Map<String, Object> attributes, String key, Object value) {
		
		if(attributes != null && key != null && !key.isEmpty() && value != null) {
			attributes.put(key, value);
		}
	}
	
	public static void addProduct(Map<String, Object> attributes, Product product) {
		if(product != null) {
			addAttribute(attributes, "Product-Title", product.getTitle());
			addAttribute(attributes, "Product-Path", product.getPath());
			addAttribute(attributes, "Product-PagePath", product.getPagePath());
		}
	}
	
	public static void addPromotion(Map<String, Object> attributes, Promotion promotion) {
		if(promotion != null) {
			addAttribute(attributes, "Promotion-Title", promotion.getTitle());
			addAttribute(attributes, "Promotion-Path", promotion.getPath());
			addAttribute(attributes, "Promotion-Type", promotion.getType());
		}
	}
	
	public static void addPage(Map<String, Object> attributes, Page page) {
		if(page != null) {
			addPage(attributes, page, null);
		}
	}
	
	public static void addPage(Map<String, Object> attributes, Page page, String prefix) {
		if(page != null) {
			addAttribute(attributes, prefix != null ? prefix + "-Page-Name" : "Page-Name", page.getName());
			addAttribute(attributes, prefix != null ? prefix + "-Page-Path" : "Page-Path", page.getPath());
			addAttribute(attributes, prefix != null ? prefix + "-Page-Title" : "Page-Title", page.getPageTitle());
		}
	}
}
