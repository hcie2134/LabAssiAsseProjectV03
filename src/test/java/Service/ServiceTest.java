package Service;

import Domain.HasId;
import Domain.Nota;
import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.StudentXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.NotaXMLService;
import Service.XMLFileService.StudentXMLService;
import Service.XMLFileService.TemaLabXMLService;
import Validator.NotaValidator;
import Validator.StudentValidator;
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

//    @Test
    public void testBigBang_addStudent() throws ValidatorException {
        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stdSrv=new StudentXMLService(strepo);
        String id = "1",nume = "nume student1",grupa = "12",email = "email@student.com",prof = "prof1";
        String[] params={id,nume,grupa,email,prof};
        stdSrv.add(params);
    }

//    @Test
    public void testBigBang_addGrade() throws ValidatorException {
        NotaValidator vn=new NotaValidator();
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        NotaXMLService notaSrv=new NotaXMLService(ntrepo);
        String id = "1",idstudent  ="1",idtema = "1",val="7",data="2018-11-02T12:00";
//        Nota n = new Nota(id, idstudent, idtema, val, data);

//        Integer idNota = Integer.parseInt(info[0]);
//        String idStudent = info[1];
//        Integer idTema = Integer.parseInt(info[2]);
//        double valoare = Double.parseDouble(info[3]);
//        //TemaLab t=findOne(idTema);
//        LocalDateTime ldt=LocalDateTime.parse(info[4]);

        String[] params={id,idstudent,idtema,val, data};
        notaSrv.add(params);
    }

    public void addGradeHelper(NotaXMLService notaSrv, String[] params) throws ValidatorException {
        notaSrv.add(params);
    }
    public void addStudentHelper(StudentXMLService srv, String[] params) throws ValidatorException {
        srv.add(params);
    }
    public void addHomeworkHelper(TemaLabXMLService srv, String[] params) throws ValidatorException {
        srv.add(params);
    }

//    public void addHomeworkHelper() throws ValidatorException {
//        TemaLabValidator vt=new TemaLabValidator();
//        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
//        TemaLabXMLService tmLbSrv=new TemaLabXMLService(tmrepo);
//        String id = "1",descr = "tema 1",saptLim = "1",saptPred = "3";
//        String[] params={id,descr,saptLim,saptPred};
//        tmLbSrv.add(params);
//    }
//    public void addHomeworkHelper() throws ValidatorException {
//        TemaLabValidator vt=new TemaLabValidator();
//        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
//        TemaLabXMLService tmLbSrv=new TemaLabXMLService(tmrepo);
//        String id = "1",descr = "tema 1",saptLim = "1",saptPred = "3";
//        String[] params={id,descr,saptLim,saptPred};
//        tmLbSrv.add(params);
//    }

    @Test
    public void testBigBang_addHomework() throws ValidatorException {
        TemaLabValidator vt=new TemaLabValidator();
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        TemaLabXMLService tmLbSrv=new TemaLabXMLService(tmrepo);
        String id = "1",descr = "tema 1",saptLim = "1",saptPred = "3";
        String[] params={id,descr,saptLim,saptPred};
        tmLbSrv.add(params);
    }



    @Test
    public void testBigBang_integrationTesting() throws ValidatorException {
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();

        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");

        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);


        String notaid = "1",idstudent  ="1",idtema = "1",val="7",data="2018-11-02T12:00";
        String nume = "nume student1",grupa = "12",email = "email@student.com",prof = "prof1";
        String[] studentparams={idstudent,nume,grupa,email,prof};
        String temaid = "1",descr = "tema 1",saptLim = "1",saptPred = "3";
        String[] homeworkparams={temaid,descr,saptLim,saptPred};

        String[] notaparams={notaid,idstudent,idtema,val, data};

        addHomeworkHelper(tmsrv, homeworkparams);
        addStudentHelper(stsrv, studentparams);
        int n = ntrepo.getSize();
        addGradeHelper(ntsrv, notaparams);
        assertEquals(ntrepo.getSize(), n + 1);
    }

}
