package Service.TxtFileService;

import Domain.HasId;
import Exceptions.ValidatorException;
import Repository.TxtFileRepository.AbstractFileRepository;
import Validator.IValidator;

public abstract  class AbstractService <ID,E extends HasId<ID>> {
    private IValidator<E> v;
    private AbstractFileRepository<ID,E> repo;
    public AbstractService(AbstractFileRepository repo){
        this.repo=repo;
    }
    //@Override
    public E add(String[] params) throws ValidatorException {
        System.out.println("Before extracting enitty...");
        E entity = repo.extractEntity(params);
//        repo.save(entity);
        System.out.println("Got entity from repo :)");
        return repo.save(entity);
    }
    public void del(ID id) throws ValidatorException {
        //E entity = repo.extractEntity(params);
        repo.delete(id);
    }
    public void upd(String[] params) throws ValidatorException {
        E entity = repo.extractEntity(params);
        repo.update(entity);
    }
    public Iterable<E> getAll(){
        return repo.findAll();
    }
    public E getById(ID id){
        return repo.findOne(id);
    }
    public int size(){
        return (int) repo.size();
    }

}

