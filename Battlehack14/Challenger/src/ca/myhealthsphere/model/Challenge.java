package ca.myhealthsphere.model;

import java.net.URL;

public class Challenge extends ModelObject {
	private String title;
	private ChallengeCategory category;
	private String description;
	private ReferenceSource referenceSource;
	private URL referenceLink;
	
	public Challenge(String title) {
		this.title = title;
	}

	public Challenge(String title, ChallengeCategory category, String description) {
		this.title = title;
		this.category = category;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ChallengeCategory getCategory() {
		return category;
	}
	public void setCategory(ChallengeCategory category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ReferenceSource getReferenceSource() {
		return referenceSource;
	}
	public void setReferenceSource(ReferenceSource referenceSource) {
		this.referenceSource = referenceSource;
	}
	public URL getReferenceLink() {
		return referenceLink;
	}
	public void setReferenceLink(URL referenceLink) {
		this.referenceLink = referenceLink;
	}
	
	@Override
	public String toString() {
		return title;
	}
}
