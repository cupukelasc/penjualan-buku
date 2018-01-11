package lab.cupu.penjualanbuku.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lab.cupu.penjualanbuku.entity.Buku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import lab.cupu.penjualanbuku.repo.BukuRepo;


@RestController
public class ApiController {

	@RequestMapping("/get-nama")
	public Map<String, Object> getNama(){
		Map<String, Object> result = new HashMap();
		result.put("nama", "Gilang");

		return result;
	}
        @Autowired
        private BukuRepo bukuRepo;

	//-- aplikasi mahasiswa 
	@RequestMapping("/daftar-buku")
        public List<Buku> ambilDaftarBuku(){
            return bukuRepo.findAll();
        }

    @RequestMapping(value = "/tambah-bku", method = RequestMethod.POST)
    public void tambahData(@RequestBody Buku bku){
    	//System.out.println("nim : " + mhs.getNim());
    	//System.out.println("nama : " + mhs.getNama());
    	//System.out.println("jurusan : " + mhs.getJurusan());
    	bukuRepo.save(bku);
    }

    @RequestMapping("/get-bku-by-id/{id}")
    public Buku getBkuById(@PathVariable("id") String id) {
    	return bukuRepo.findOneById(id);
    }

    @RequestMapping(value = "/hapus-data/{id}", method = RequestMethod.DELETE)
    public void hapusData(@PathVariable("id") String id){
        bukuRepo.delete(id);
    }


    @RequestMapping("/keluar")
    public void keluar(HttpServletRequest req, 
        HttpServletResponse resp) {
        Authentication auth = SecurityContextHolder
            .getContext().getAuthentication();
        new SecurityContextLogoutHandler()
            .logout(req, resp, auth);
    }


}