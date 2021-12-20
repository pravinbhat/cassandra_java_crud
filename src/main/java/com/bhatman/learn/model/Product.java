package com.bhatman.learn.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
	private UUID prodId;
	private String created;
	private String description;
	private String dim;
	private String location;
	private String name;
	private String updated;
	private double weight;

}
