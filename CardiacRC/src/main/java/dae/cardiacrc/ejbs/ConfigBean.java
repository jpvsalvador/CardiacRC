package dae.cardiacrc.ejbs;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.EJB;
import java.util.logging.Level;
import java.util.logging.Logger;

@Startup
@Singleton
public class ConfigBean {
    @EJB
    ProfessionalBean professionalBean = new ProfessionalBean();

    @EJB
    PatientBean patientBean = new PatientBean();

    private static final Logger logger = Logger.getLogger("ejbs.ConfigBean");

    @PostConstruct
    public void populateDB(){
        try {
            professionalBean.create("tomasalves", 987654321, "Tomás Alves", "12345", "tomas.alves@mail.com");
            patientBean.create("joaosalvador", 123456789, "João Salvador", "12345", "joao.salvador@mail.com", "tomasalves");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
