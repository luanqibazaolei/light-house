package com.light.mng.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 演出表
 * </p>
 *
 * @author light
 * @since 2021-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_show_info")
@ApiModel(value="ShowInfo对象", description="演出表")
public class ShowInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "演出号")
    @TableId("S_ID")
    private Long sId;

    @ApiModelProperty(value = "演出名称")
    @TableField("S_NAME")
    private String sName;

    @ApiModelProperty(value = "乐队号")
    @TableField("B_ID")
    private Long bId;

    @ApiModelProperty(value = "乐队名")
    @TableField("B_NAME")
    private String bName;

    @ApiModelProperty(value = "演出图片")
    @TableField("S_IMG")
    private String sImg;

    @ApiModelProperty(value = "场地号")
    @TableField("P_ID")
    private Long pId;

    @ApiModelProperty(value = "演出日期")
    @TableField("SHOW_DATE")
    private LocalDate showDate;

    @ApiModelProperty(value = "创建时间")
    @TableField("DT_CREATE")
    private LocalDateTime dtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField("DT_UPDATE")
    private LocalDateTime dtUpdate;

    @ApiModelProperty(value = "状态")
    @TableField("STATUS")
    private Integer status;


}
