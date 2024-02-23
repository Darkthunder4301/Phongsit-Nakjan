package nvc.it.phongsit.newton.controller;
import org.springframework.web.bind.annotation.RestController;
import nvc.it.phongsit.newton.model.Camera;
import nvc.it.phongsit.newton.repository.CameraRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/camera")
public class CameraController {
    
    @Autowired
    private CameraRepository cameraRepository;

    @GetMapping("")
    public Iterable<Camera> getAll(){
        return cameraRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Camera> getById(@PathVariable int id){
        return cameraRepository.findById(id);
    }

    @GetMapping("/ip/{ipaddress}")
    public Iterable<Camera> getByIPAddress(@PathVariable String IPAddress){
        return cameraRepository.findByIPAddress(IPAddress);
    }

    @GetMapping("/location/{location}")
    public Iterable<Camera> getByLocation(@PathVariable String location){
        return cameraRepository.findByLocation(location);
    }

    @PostMapping("")
    public ResponseEntity<Camera> create(@RequestBody Camera camera){
        Camera newCam = cameraRepository.save(camera);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCam);
    }
}