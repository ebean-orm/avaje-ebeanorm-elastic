package org.example.domain;

import io.ebean.Model;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.sql.Timestamp;

@MappedSuperclass
public abstract class BaseDomain extends Model {

	@WhenCreated
	Timestamp whenCreated;
	
	@WhenModified
	Timestamp whenModified;

	@Version
	Long version;

  public Timestamp getWhenCreated() {
    return whenCreated;
  }

  public void setWhenCreated(Timestamp whenCreated) {
    this.whenCreated = whenCreated;
  }

  public Timestamp getWhenModified() {
    return whenModified;
  }

  public void setWhenModified(Timestamp whenModified) {
    this.whenModified = whenModified;
  }

  public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
