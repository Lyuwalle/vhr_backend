package com.lyuwalle.backend.controller.system.basic;

import com.lyuwalle.backend.common.RespBean;
import com.lyuwalle.backend.domain.JobLevel;
import com.lyuwalle.backend.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lyuxiyang
 */
@RestController
@RequestMapping("/system/basic/jobLevel")
public class JobLevelController {

    @Autowired
    private JobLevelService jobLevelService;

    @GetMapping("/")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            return RespBean.ok("添加职称成功");
        }
        return RespBean.error("添加职称失败");
    }

    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.updateJobLevel(jobLevel) == 1) {
            return RespBean.ok("更新职称成功");
        }
        return RespBean.error("更新职称失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelById(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevelById(id) == 1) {
            return RespBean.ok("删除职位成功");
        }
        return RespBean.error("删除职位失败,该职位下可能上有员工");
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevelByIds(Integer[] ids) {
        if (jobLevelService.deleteJobLevelByIds(ids) == ids.length) {
            return RespBean.ok("批量删除职位成功");
        }
        return RespBean.error("批量删除职位失败,该职位下可能上有员工");
    }
}
