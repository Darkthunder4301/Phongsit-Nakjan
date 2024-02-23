package nvc.it.phongsit.newton.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import nvc.it.phongsit.newton.model.Camera;

public interface CameraRepository extends CrudRepository<Camera, Integer> {
    List<Camera> findByIPAddress(String ipAddress);
    List<Camera> findByLocation(String location);
}