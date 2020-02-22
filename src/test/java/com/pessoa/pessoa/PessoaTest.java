package com.pessoa.pessoa;

import com.pessoa.utils.CpfCnpjUtils;
import org.junit.Assert;
import org.junit.Test;

public class PessoaTest {

    @Test
    public void validarCpfInvalidoPessoa() {
        Assert.assertFalse(CpfCnpjUtils.isValid("111111"));
    }

    @Test
    public void validarCpfValidoPessoa() {
        Assert.assertTrue(CpfCnpjUtils.isValid("13341639012"));
    }
}
