package com.cy.store;

import com.cy.store.entity.Address;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.mapper.DistrictMapper;
import com.cy.store.service.IAddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressMapperTests {

    @Autowired
    private AddressMapper addressMapper;
    
    @Autowired
    private IAddressService addressService;
    
    @Autowired
    private DistrictMapper districtMapper;

    @Test
    public void insert() {
        Address address = new Address();
        address.setUid(11);
        address.setPhone("133336");
        address.setName("昂热");  
        addressMapper.insert(address);
    }

    @Test
    public void countByUid() {
        Integer count = addressMapper.countByUid(11);
        System.out.println(count);
    }
    
    @Test
    public void addNewAddress() {
        Address address = new Address();
        address.setPhone("175726");
        address.setName("象龟");
        addressService.addNewAddress(11,"mxy",address);
    }
    
    @Test
    public void findByAid() {
        System.err.println(addressMapper.findByAid(5));
    }

    @Test
    public void updateNonDefault() {
        System.out.println(addressMapper.updateNonDefault(11));//有几条数据影响行数就输出几
    }

    @Test
    public void updateDefaultByAid() {
        addressMapper.updateDefaultByAid(5,"lalala",new Date());
    }

}
