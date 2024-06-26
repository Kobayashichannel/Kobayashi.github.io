package cn.itcast.mp.pojo;

import cn.itcast.mp.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName("tb_user")
//@KeySequence(value = "SEQ_USER", clazz = long.class)
public class User extends Model<User> {

//    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;

    //设置查询时指定的字段不返回数据
    //插入数据时填充
    @TableField(select = false, fill = FieldFill.INSERT)
    private String password;
    private String name;
    private Integer age;

    @TableField(value = "email") //指定数据表中的字段名
    private String mail;

    @TableField(exist = false)
    private String address; //在数据库表中是不存在的

    @Version //乐观锁的版本字段
    private Integer version;

    @TableLogic //逻辑删除字段,1-删除, 0-未删除
    private Integer deleted;

    private SexEnum sex; //性别，枚举类型

}
