package Service;

import Domain.HasId;
import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.TemaLabXMLService;
import Validator.TemaLabValidator;

import org.junit.Test;
import java.io.IOException;
import org.junit.internal.JUnitSystem;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class ServiceTest {

    @Test
    public void testAddHomework_AddsHomework() throws ValidatorException {

        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);

        String descr = "description 1", id = "1", saptLim = "1", saptPred = "1";
        String[] params={id,descr,saptLim,saptPred};
        TemaLab result = new TemaLab(1, descr, 1, 1);
        System.out.println("heree");
//        HasId<TemaLab> execResult = tmsrv.add(params); //, result);
        assertEquals(tmsrv.add(params).getId(), result.getId());
    }

    @Test
    public void testAddHomework_TestExistingHomework() throws ValidatorException {

        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);

        String descr = "description 1", id = "1", saptLim = "1", saptPred = "1";
        String[] params={id,descr,saptLim,saptPred};
        TemaLab result = new TemaLab(1, descr, 1, 1);
        System.out.println("heree");
        assertEquals(tmsrv.add(params).getId(), result.getId());
        assertEquals(tmsrv.add(params).getId(), result.getId());
    }


    // WBT below.
    @Test
    public void testAddHomework_testExtractEntityFailsInvalidIdType() throws ValidatorException {
        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);

        String descr = "description 1", id = "1a", saptLim = "1", saptPred = "1";
        String[] params={id,descr,saptLim,saptPred};
        Assertions.assertThrows(NumberFormatException.class, () -> {
            tmsrv.add(params);});
    }
    @Test
    public void testAddHomework_testExtractEntityFailsInvalidWeekType() throws ValidatorException {
        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);

        String descr = "description 1", id = "1", saptLim = "abc", saptPred = "1";
        String[] params={id,descr,saptLim,saptPred};
        Assertions.assertThrows(NumberFormatException.class, () -> {
            tmsrv.add(params);});
    }
    @Test
    public void testAddHomework_testExtractEntityFailsInvalidWeekPredType() throws ValidatorException {
        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);

        String descr = "description 1", id = "1", saptLim = "1", saptPred = "1abc";
        String[] params={id,descr,saptLim,saptPred};
        Assertions.assertThrows(NumberFormatException.class, () -> {
            tmsrv.add(params);});
    }
    @Test
    public void testAddHomework_testExtractEntityFailsInvalidWeekPred() throws ValidatorException {
        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);

        String descr = "description 1", id = "1", saptLim = "1", saptPred = "1abc";
        String[] params={id,descr,saptLim,saptPred};
        Assertions.assertThrows(NumberFormatException.class, () -> {
            tmsrv.add(params);});
    }
    @Test
    public void testAddHomework_testIdEmpty() throws ValidatorException {
        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);

        String descr = "description 1", id = "1", saptLim = "1", saptPred = "2";
        String[] params={"",descr,saptLim,saptPred};
        Assertions.assertThrows(NumberFormatException.class, () -> {
            tmsrv.add(params);});
    }
    @Test
    public void testAddHomework_testDescrEmpty() throws ValidatorException {
        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);

        String descr = "description 1", id = "1", saptLim = "1", saptPred = "1";
        String[] params={id,"",saptLim,saptPred};
        Assertions.assertThrows(ValidatorException.class, () -> {
            tmsrv.add(params);});
    }
    @Test
    public void testAddHomework_testDescrNull() throws ValidatorException {
        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);

        String descr = "description 1", id = "1", saptLim = "1", saptPred = "1";
        String[] params={id,null,saptLim,saptPred};
        Assertions.assertThrows(ValidatorException.class, () -> {
            tmsrv.add(params);});
    }
    @Test
    public void testAddHomework_testWeekLimSmallerThan0() throws ValidatorException {
        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);

        String descr = "description 1", id = "1", saptLim = "-11", saptPred = "1";
        String[] params={id,null,saptLim,saptPred};
        Assertions.assertThrows(ValidatorException.class, () -> {
            tmsrv.add(params);});
    }
    @Test
    public void testAddHomework_testWeekDeadlineSmallerThan0() throws ValidatorException {
        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);

        String descr = "description 1", id = "1", saptLim = "1", saptPred = "-31";
        String[] params={id,null,saptLim,saptPred};
        Assertions.assertThrows(ValidatorException.class, () -> {
            tmsrv.add(params);});
    }
    @Test
    public void testAddHomework_testWeekLimBiggerThan14() throws ValidatorException {
        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);

        String descr = "description 1", id = "1", saptLim = "100", saptPred = "1";
        String[] params={id,null,saptLim,saptPred};
        Assertions.assertThrows(ValidatorException.class, () -> {
            tmsrv.add(params);});
    }
    @Test
    public void testAddHomework_testWeekDeadlineBiggerThan14() throws ValidatorException {
        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);

        String descr = "description 1", id = "1", saptLim = "1", saptPred = "31";
        String[] params={id,null,saptLim,saptPred};
        Assertions.assertThrows(ValidatorException.class, () -> {
            tmsrv.add(params);});
    }
    @Test
    public void testAddHomework_testRepoFileInvalid() throws ValidatorException {
        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXMLInvalid.xml");
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);

        String descr = "description 1", id = "1", saptLim = "1", saptPred = "3";
        String[] params={id,null,saptLim,saptPred};
        Assertions.assertThrows(ValidatorException.class, () -> {
            tmsrv.add(params);});
    }
}
