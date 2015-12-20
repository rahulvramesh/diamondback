package com.topera.epoch.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="key_to_name")
public class KeyToName
{
  @Id
  @GeneratedValue
  private Integer id;
  private String keyName;
  private String name;
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getKeyName()
  {
    return this.keyName;
  }
  
  public void setKeyName(String keyName)
  {
    this.keyName = keyName;
  }
}
