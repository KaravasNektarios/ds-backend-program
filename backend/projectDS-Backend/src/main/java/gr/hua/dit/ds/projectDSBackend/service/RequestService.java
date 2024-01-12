package gr.hua.dit.ds.projectDSBackend.service;

import gr.hua.dit.ds.projectDSBackend.entity.Farmer;
import gr.hua.dit.ds.projectDSBackend.entity.Request;
import gr.hua.dit.ds.projectDSBackend.repository.RequestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Transactional
    public List<Request> getRequests() {
        return requestRepository.findAll();
    }

    @Transactional
    public void saveRequest(Request request) {
        requestRepository.save(request);
    }

    @Transactional
    public void deleteRequestById(Integer requestId) {
        requestRepository.deleteById(requestId);
    }

    @Transactional
    public Request getRequestById(Integer requestId) {
        return requestRepository.findById(requestId).get();
    }

    @Transactional
    public Boolean existsRequestById(Integer requestId) {
        return requestRepository.existsById(requestId);
    }

    @Transactional
    public Set<Farmer> getCollaborationFromRequestById(Integer requestId) {
        Request request = requestRepository.findById(requestId).get();
        return request.getFarmers();
    }
}
