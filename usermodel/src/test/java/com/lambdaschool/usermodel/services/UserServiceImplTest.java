package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.UserModelApplication;
import com.lambdaschool.usermodel.models.User;
import com.lambdaschool.usermodel.models.UserRoles;
import com.lambdaschool.usermodel.models.Useremail;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserModelApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest
{

    @Autowired
    private  UserService uservice;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

    }

    @After
    public void tearDown() throws Exception
    {
    }

    //working
    @Test
    public void afindUserById()
    {
        assertEquals("test admin", uservice.findUserById(4).getUsername());
    }
    @Test
    public void bfindAll()
    {
        assertEquals(30,uservice.findAll().size());
    }

    @Test
    public void cupdate()
    {
        List<UserRoles> roles = new ArrayList<>();

        User newUser = new User("starelton",
                "lover123",
                "s@gmail.com",
                roles  );

        User updateUser = uservice.update(newUser, 10);
        assertEquals("s@gmail.com", updateUser.getPrimaryemail());

    }

    @Test
    public void dfindByNameContaining()
    {


    }

    //working


    @Test
    public void cdelete()
    {
        uservice.delete(4);
        assertEquals(29, uservice.findAll().size());
    }

    // working but idk if it is necacary
    @Test (expected = EntityNotFoundException.class)
    public void cadeletenotfound()
    {
       uservice.delete(9999);
        assertEquals(29, uservice.findAll().size());
    }

    @Test
    public void efindByName()
    {
    }

    @Test
    public void fsave()
    {
        //String username
        //String password
        //String primaryemail
        //List<UserRoles> roles

        // this mother fucking workssss hhahaha what are the chances

        List<UserRoles> roles = new ArrayList<>();

        User newUser = new User("graceelton",
                                "lover123",
                                   "g@gmail.com",
                                           roles  );

        User addUser = uservice.save(newUser);

        // make sure the object is not empty
        assertNotNull(addUser);
        User foundUser = uservice.findUserById(addUser.getUserid());
        assertEquals(addUser.getUsername(),foundUser.getUsername());
    }

    //working


    @Test
    public void ggetCountUserEmails()
    {

    }

    @Test
    public void hdeleteUserRole()
    {

    }

    @Test
    public void iaddUserRole()
    {

    }
}