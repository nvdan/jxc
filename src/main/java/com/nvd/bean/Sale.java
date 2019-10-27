package com.nvd.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nvd.serializer.DateToLongSerializer;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sale")
public class Sale  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private java.math.BigDecimal price;

	private Integer quantity;

	@Column(name = "total_price")
    @JsonProperty(value = "totalprice")
	private java.math.BigDecimal totalPrice;

	@Column(name = "sale_date")
    @JsonProperty(value = "saleDate")
    @JsonSerialize(using = DateToLongSerializer.class)
	private java.util.Date saleDate;

	@Column(name = "user_id")
    @JsonIgnore
	private Integer userId;

	@JsonIgnore
	@Column(name = "product_id")
	private Integer productId;

	@Transient
    private String productName;

	@Transient
    private String realName;

}
