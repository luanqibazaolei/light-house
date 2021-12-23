package com.light.show.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 乐队信息表
 * </p>
 *
 * @author light
 * @since 2021-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_band_info")
@ApiModel(value="BandInfo对象", description="乐队信息表")
public class BandInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "乐队ID")
    @TableId("B_ID")
    private Long bId;

    @ApiModelProperty(value = "乐队名")
    @TableField("B_NAME")
    private String bName;

    @ApiModelProperty(value = "备注")
    @TableField("REMARK")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    @TableField("DT_CREATE")
    private LocalDateTime dtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField("DT_UPDATE")
    private LocalDateTime dtUpdate;

    @TableLogic
    @ApiModelProperty(value = "状态")
    @TableField("STUATS")
    private String stuats;


}
