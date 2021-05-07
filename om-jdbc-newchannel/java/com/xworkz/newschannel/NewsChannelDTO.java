package com.xworkz.newschannel;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class NewsChannelDTO implements Serializable {

	@NonNull
	private int id;
	@NonNull
	private String name;
	@NonNull
	private String owner;
	@NonNull
	private String editor;
	@NonNull
	private String lang;

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof NewsChannelDTO) {
			NewsChannelDTO dto = (NewsChannelDTO) obj;
			if (this.getName().equals(getName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 99;
	}

}
