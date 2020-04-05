package Repository.TxtFileRepository;

import Domain.HasId;
import Domain.TemaLab;
import Exceptions.RepositoryException;
import Validator.TemaLabValidator;

import java.io.*;

public class TemaLabFileRepo extends AbstractFileRepository {
    public TemaLabFileRepo(String filename, TemaLabValidator val) throws IOException {
        super(val, filename);
    }

    @Override
    public HasId extractEntity(String[] info) throws RepositoryException {
        try {
            int id = Integer.parseInt(info[0]);
            String descr = info[1];
            int sptLim = Integer.parseInt(info[2]);
            int sptPred = Integer.parseInt(info[3]);
            TemaLab t = new TemaLab(id, descr, sptLim, sptPred);
//            System.out.println("Created tema lab.");
            return t;
        } catch (Exception e){
            throw new RepositoryException("Could not parse all parameters for creating homework.");
        }
    }
}