/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 18:22
 */

package com.prince.frame.admin;

import com.prince.entity.Admin;
import com.prince.entity.Teacher;
import com.prince.frame.BaseFrame;

public class AdminFrame extends BaseFrame {
    private Admin admin;

    public AdminFrame(Admin admin){
        this.admin = admin;
        setTitle("管理员登录");
    }

}
