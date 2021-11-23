package com.lyuwalle.backend.controller.system.basic;

import com.lyuwalle.backend.common.RespBean;
import com.lyuwalle.backend.domain.Position;
import com.lyuwalle.backend.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lyuxiyang
 */
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping("/")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position) {
        if(positionService.addPosition(position) == 1) {
            return RespBean.ok("成功添加职位");
        }
        return RespBean.error("添加职位失败");
    }

    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position) {
        if(positionService.updatePosition(position) == 1) {
            return RespBean.ok("成功更新职位");
        }
        return RespBean.error("更新职位失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePositionById(@PathVariable Integer id) {
        if(positionService.deletePositionById(id) == 1) {
            return RespBean.ok("删除职位成功");
        }
        return RespBean.error("删除职位失败,该职位可能尚有员工");
    }

    @DeleteMapping("/")
    public RespBean deletePositionByIds(Integer[] ids) {
        if(positionService.deletePositionByIds(ids) == ids.length) {
            return RespBean.ok("批量删除职位成功");
        }
        return RespBean.error("批量删除职位失败,该职位可能尚有员工");
    }

}
