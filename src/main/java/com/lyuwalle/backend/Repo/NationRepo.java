package com.lyuwalle.backend.Repo;

import com.lyuwalle.backend.domain.Nation;
import com.lyuwalle.backend.mapper.NationDBMapper;
import com.lyuwalle.backend.model.DepartmentDB;
import com.lyuwalle.backend.model.NationDB;
import com.lyuwalle.backend.utils.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NationRepo {

    @Autowired
    private NationDBMapper nationDBMapper;

    public List<Nation> getAllNations() {
        return nationDBMapper.selectAll().stream().map(nationDB -> BeanCopyUtil.copy(nationDB, Nation.class)).collect(Collectors.toList());
    }

    public Nation getNationById(Integer nationId) {
        NationDB nationDB = new NationDB();
        nationDB.setId(nationId);
        return BeanCopyUtil.copy(nationDBMapper.selectByPrimaryKey(nationDB), Nation.class);
    }

    public Nation getNationByName(String nationName) {
        NationDB nationDB = new NationDB();
        nationDB.setName(nationName);
        return BeanCopyUtil.copy(nationDBMapper.selectOne(nationDB), Nation.class);
    }
}
