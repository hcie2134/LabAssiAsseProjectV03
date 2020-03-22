package Service;

import Domain.HasId;
import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.TemaLabXMLService;
import Validator.TemaLabValidator;

import org.junit.Test;
import org.junit.internal.JUnitSystem;
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
}
