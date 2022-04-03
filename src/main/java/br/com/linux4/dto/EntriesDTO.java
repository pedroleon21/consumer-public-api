package br.com.linux4.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EntriesDTO extends Count {

	String entries;

	public String getEntries() {
		return entries;
	}

	public void setEntries(String entries) {
		this.entries = entries;
	}

}
