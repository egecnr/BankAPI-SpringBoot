package io.swagger.model.dtos;

import io.swagger.model.Account;
import io.swagger.model.IbanGenerator;
import io.swagger.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateAccountDtoTest {

    @MockBean
    private CreateAccountDTO account;

    @MockBean
    private User user;

    @Autowired
    private IbanGenerator ibanGenerator;


    @BeforeEach
    public void init() {
        this.user = new User("Egemin", "Cilierli", "egecilierli@gmail.com", "thisisnotapaassword", "+31 06 29297273", User.RoleEnum.ROLE_CUSTOMER);
        this.account = new CreateAccountDTO( BigDecimal.valueOf(200), this.user.getId(), Account.StatusEnum.ACTIVE, BigDecimal.valueOf(2000), Account.TypeEnum.CURRENT);
    }

    //This class is only testing the get and set methods, nothing specific
    @Test
    public void createAccountShouldNotBeNull() {
        Assertions.assertNotNull(account);
    }


    @Test
    public void accountHasCorrectStatus(){
        assertEquals(account.getStatus(), Account.StatusEnum.ACTIVE);
    }

    @Test
    public void accountHasCorrectType(){
        assertEquals(account.getType(), Account.TypeEnum.CURRENT);
    }

    @Test
    public void accountHasCorrectUser(){
        assertEquals(account.getUserId(),this.user.getId());
    }

    @Test
    public void accountHasCorrectBalance(){
        assertEquals(this.account.getBalance(),BigDecimal.valueOf(2000));
    }

    @Test
    public void accountHasCorrectAbsoluteLimit(){
        assertEquals(this.account.getAbsoluteLimit(),BigDecimal.valueOf(200));
    }



}
