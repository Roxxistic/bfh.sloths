package ch.bfh.sloths.yellowpages.partnerservice.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public interface Partner {

    String getId();

    void setId(String id);

    String getName();
}
