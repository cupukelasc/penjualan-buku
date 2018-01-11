/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.cupu.penjualanbuku.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lab.cupu.penjualanbuku.entity.Buku;
/**
 *
 * @author User
 */
@Repository
public interface BukuRepo extends JpaRepository<Buku, String> {
	Buku findOneById(String id);
    
    
}
