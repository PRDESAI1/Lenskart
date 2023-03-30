package com.capgemini.lenscart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lenscart.exception.PriceNegativeException;
import com.capgemini.lenscart.exception.WrongLoginException;
import com.capgemini.lenscart.model.Frame;
import com.capgemini.lenscart.model.Glass;
import com.capgemini.lenscart.model.Lens;
import com.capgemini.lenscart.model.Login;
import com.capgemini.lenscart.model.Sunglass;
import com.capgemini.lenscart.service.AdminLoginService;
import com.capgemini.lenscart.service.FrameService;
import com.capgemini.lenscart.service.GlassService;
import com.capgemini.lenscart.service.LensService;
import com.capgemini.lenscart.service.SunglassService;


@RestController
@CrossOrigin
@RequestMapping(path="/product")//mapping web requests onto methods in request-handling classes
public class AdminController {

  
	@Autowired
	FrameService adminService;
	
	@Autowired
	GlassService adminGlassService;
	
	@Autowired
	LensService adminLensService;
	
	@Autowired
	SunglassService adminSunglassService ;
	@Autowired
	AdminLoginService adminLoginService;
	
	/**
	 * adminLogin method is use to check admin emailId and password
	 * @param emailId 
	 * @param password
	 * @return  message
	 */
	
	//http://localhost:8086/lenscart/product/adminLogin/prasaddeshmukh23@gmail.com/rsedf3890
	//http://localhost:8087/lenscart/product/adminLogin
		@PostMapping(value = "/adminLogin")
		public  ResponseEntity<String>  adminlogin(@RequestBody Login login) throws WrongLoginException {
		String message=	adminLoginService.adminLogin(login);
			
			return ResponseEntity.ok(message);
		
		

	}
	
	/**
	 * 	
	 * @return list of all frames
	 */
	//http://localhost:8086/lenscart/product
	@RequestMapping//getting all list of frames which added by admin
	public List<Frame> getFrame(){
		System.out.println("getting all list of frames");
		List<Frame> frameList=adminService.getFrame();
		return frameList;
		
	}
	
	
	/**
	 * adding new frame
	 * @param frame  frame object
	 * @return newly added frame
	 * @throws PriceNegativeException 
	 */
	//http://localhost:8086/lenscart/product
	@PostMapping( consumes = "application/json", produces = "application/json")
	public ResponseEntity<Frame> addFrame(@RequestBody Frame frame) throws PriceNegativeException { 
		adminService.addFrame(frame);
		System.out.println("add frame in database");
		return ResponseEntity.ok(frame);
			
	}
	
	
	/**
	 * updating frame
	 * @param frame frame object
	 * @return updated version of frame
	 */
	//http://localhost:8086/lenscart/product/upadateFrame/8
	@PutMapping("/upadateFrame/{frameId}")
	public ResponseEntity<Frame> updateFrame(@RequestBody Frame frame){
		
		Frame frame1= adminService.updateFrame(frame);
		System.out.println("update frame in database");
		return new ResponseEntity<>(frame1, HttpStatus.OK);
		
	}
	/**
	 * deleting frame by frameId
	 * @param frameId 
	 * @return list of remaining frames
	 */
	
	//http://localhost:8086/lenscart/product/5
	@DeleteMapping(path = "{frameId}", produces = "application/json")
	public ResponseEntity<List<Frame>> deleteFrame(@PathVariable("frameId") int frameId) {
		List<Frame> frame= adminService.deleteFrame(frameId);
		System.out.println("delete frame in database");
		return new ResponseEntity<>(frame, HttpStatus.OK);
		
	}
	
	@RequestMapping(path = "{id}")
    public ResponseEntity<Optional<Frame>> getFrameById(@PathVariable("id") int id) {
        Optional<Frame> frame = adminService.findFrameById(id);
        return ResponseEntity.ok(frame);

    }
	
	/**
	 * 
	 * @return list of all Glass 
	 */
	
	//http://localhost:8086/lenscart/product/getGlass
	@RequestMapping(path="/getGlass")
	public List<Glass> getGlass(){
		List<Glass> glassList=adminGlassService.getGlass();
		return glassList;
		
	}
	/**
	 * adding new glass
	 * @param glass glass object 
	 * @return newly added glass
	 */
	//http://localhost:8086/lenscart/product/addGlass
	@PostMapping(value = "/addGlass", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Glass> addGlass(@RequestBody Glass glass) { 
		adminGlassService.addGlass(glass);
		System.out.println("add glass in database");
		return ResponseEntity.ok(glass);
		
		
	}
	/**
	 * Updating glass 
	 * @param glass glass object
	 * @return updated version of glass
	 */
	
	//http://localhost:8086/lenscart/product/putGlass
	@PutMapping("/putGlass/{glassId}")
	public ResponseEntity<Glass> updateGlass(@RequestBody Glass glass){
		System.out.println(glass);
		Glass glass1= adminGlassService.updateGlass(glass);
		System.out.println("update Glass in database");
		return new ResponseEntity<Glass>(glass1, HttpStatus.OK);
		
	}
	/**
	 * deleting glass by glassId
	 * @param glassId
	 * @return list of remaining glass
	 */
	//http://localhost:8086/lenscart/product/1
	@DeleteMapping(path = "/deleteGlass/{glassId}", produces = "application/json")
	public ResponseEntity<List<Glass>> deleteGlass(@PathVariable("glassId") int glassId) {
		List<Glass> glass= adminGlassService.deleteGlass(glassId);
		System.out.println("delete Glass in database");
		return new ResponseEntity<List<Glass>>(glass, HttpStatus.OK);
		

	}
	
	//http://localhost:8086/lenscart/product/getGlassById/101
    @RequestMapping(path = "/getGlassById/{id}")
    public ResponseEntity<Optional<Glass>> getGlassById(@PathVariable("id") int id) {
    Optional<Glass> glass = adminGlassService.getGlassById(id);
    return ResponseEntity.ok(glass);}
	
	/**
	 * 
	 * @return list of all Lens
	 */
	//http://localhost:8086/lenscart/product/getLens
	@RequestMapping(path="/getLens")
	public List<Lens> getLens(){
		List<Lens> lensList=adminLensService.getLens();
		return lensList;
		}
	/**
	 * adding new lens
	 * @param lens object 
	 * @return newly added glass
	 */
	
	//http://localhost:8086/lenscart/product/addLens
	@PostMapping(value = "/addLens", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Lens> addLens(@RequestBody Lens lens) { 
		adminLensService.addLens(lens);
		System.out.println("add Lens in database");
		return ResponseEntity.ok(lens);
		
		
	}
	/**
	 * updating lens
	 * @param lens lens object
	 * @return updated version of lens
	 */
	
	//http://localhost:8086/lenscart/product/putLens/{id}
	@PutMapping(path="/putLens/{id}")
	public ResponseEntity<Lens> updateLens(@RequestBody Lens lens){
		System.out.println(lens);
		Lens lens1= adminLensService.updateLens(lens);
		System.out.println("update Lens in database");
		return new ResponseEntity<Lens>(lens1, HttpStatus.OK);
		
	}
	//http://localhost:8086/lenscart/product/getLensById/{id}
	@RequestMapping(path="/getLensById/{id}")
    public ResponseEntity<Optional<Lens>> getLensById(@PathVariable("id") int id) {
    Optional<Lens> lens = adminLensService.getLensById(id);
    return ResponseEntity.ok(lens);
}
	/**
	 * deleting lens by lensId
	 * @param lensId
	 * @return list of remaining lens
	 */
	
	//http://localhost:8086/lenscart/product/deleteLens/4
	@DeleteMapping(path = "/deleteLens/{lensId}", produces = "application/json")
	public ResponseEntity<List<Lens>> deleteLens(@PathVariable("lensId") int lensId) {
		List<Lens> lens= adminLensService.deleteLens(lensId);
		System.out.println("delete Lens in database");
		return new ResponseEntity<List<Lens>>(lens, HttpStatus.OK);
		

	}
	/**
	 * 
	 * @return list of all sunglass
	 */
	
	//http://localhost:8086/lenscart/product/getSunglass
	@RequestMapping(path="/getSunglass")
	public List<Sunglass> getSunglass(){
		List<Sunglass> SunglassList=adminSunglassService.getSunglass();
		return SunglassList;
		
	}
	
	/**
	 * adding new sunglass
	 * @param sunglass object  
	 * @return newly added glass
	 */
	
	//http://localhost:8086/lenscart/product/addSunglass
	@PostMapping(value = "/addSunglass", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Sunglass> addSunglass(@RequestBody Sunglass sunglass) { 
	 adminSunglassService.addSunglass(sunglass);
		System.out.println("add Sunglass in database");
		return ResponseEntity.ok(sunglass);
		
		
	}
	
	/**
	 * updating sunglass
	 * @param sunglass sunglass object
	 * @return updated version of sunglass
	 */
	
	//http://localhost:8086/lenscart/product/updateSunglass/{sunglassId}
	@PutMapping("/updateSunglass/{sunglassId}")
	public ResponseEntity<Sunglass> updateSunglass(@RequestBody Sunglass sunglass){
		System.out.println(sunglass);
		Sunglass sunglass1= adminSunglassService.updateSunglass(sunglass);
		System.out.println("update Sunglass in database");
		return new ResponseEntity<Sunglass>(sunglass1, HttpStatus.OK);
		
	}
	/**
	 * deleting sunglass by sunglassId
	 * @param sunglassId
	 * @return list of remaining sunglass
	 */
	
	//http://localhost:8086/lenscart/product/deleteSunglass/3
	@DeleteMapping(path = "/deleteSunglass/{sunglassId}", produces = "application/json")
	public ResponseEntity<List<Sunglass>> deleteSunglass(@PathVariable("sunglassId") int sunglassId) {
		List<Sunglass> sunglass= adminSunglassService.deleteSunglass(sunglassId);
		System.out.println("delete Sunglass in database");
		return new ResponseEntity<List<Sunglass>>(sunglass, HttpStatus.OK);
		
	}
	
	//http://localhost:8080/lenscart/product/getSunglassById/2
    @RequestMapping(path = "/getSunglassById/{id}")
    public ResponseEntity<Optional<Sunglass>> getSunglassById(@PathVariable("id") int id) {
    Optional<Sunglass> sunglass = adminSunglassService.getSunglassById(id);
    return ResponseEntity.ok(sunglass);

    }
	
	
	
	
	

}
