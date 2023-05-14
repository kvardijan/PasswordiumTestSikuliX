import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sikuli.script.*;

import java.time.LocalDateTime;

import static javafx.application.Platform.exit;
import static org.junit.Assert.assertTrue;

public class PasswordiumTest {
    private App passwordium = new App("C:\\Users\\Karlo\\IdeaProjects\\Passwordium\\out\\artifacts\\passwordium_jar\\passwordium.jar");
    private Screen screen;
    private Region region;
    @Before
    public void setUp() {
        if(passwordium.isRunning()){
            passwordium.focus();
            System.out.println("postoji");
        }else{
            System.out.println("ne postoji");
            passwordium.open();
        }
        screen = new Screen();
        ImagePath.add(System.getProperty("user.dir"));
        region = new Region(screen.getBounds());
    }

    @Test
    public void testPasswordiumOpen(){
        assertTrue(screen.exists("images/prijava_screen.png") != null);
    }

    @Test
    public void testLogin() throws FindFailed {
        screen.wait("images/txtBox.png", 10);
        screen.click("images/txtBox.png");
        screen.type("karlokorisnik" + Key.ENTER);
        screen.type(Key.TAB);
        screen.type("hgrsdrgeshtyjfyjhrtcht" + Key.ENTER);
        screen.wait("images/btnPrijava.png", 10);
        screen.click("images/btnPrijava.png");
        Assert.assertNotNull(screen.wait("images/glavniScreen.png", 15));
    }

    @Test
    public void testAddAccount() throws FindFailed {
        screen.wait("images/txtBox.png", 10);
        screen.click("images/txtBox.png");
        screen.type("karlokorisnik" + Key.ENTER);
        screen.type(Key.TAB);
        screen.type("hgrsdrgeshtyjfyjhrtcht" + Key.ENTER);
        screen.wait("images/btnPrijava.png", 10);
        screen.click("images/btnPrijava.png");

        screen.wait("images/btnDodaj.png", 10);
        screen.click("images/btnDodaj.png");

        int vrijeme = LocalDateTime.now().getSecond();
        int vrijeme2 = LocalDateTime.now().getMinute();
        screen.type("racun" + vrijeme + vrijeme2);
        screen.type(Key.TAB);
        screen.type("www.url.com" + vrijeme + vrijeme2);
        screen.type(Key.TAB);
        screen.type("korime" + vrijeme + vrijeme2);

        screen.wait("images/btnGeneriraj.png", 10);
        screen.click("images/btnGeneriraj.png");
        screen.wait("images/btnDodajRacun.png", 10);
        screen.click("images/btnDodajRacun.png");
        screen.wait("images/btnOK.png", 10);
        screen.click("images/btnOK.png");

        Assert.assertNotNull(screen.wait("images/glavniScreen.png", 15));
    }


    @Test
    public void testEditAccount() throws FindFailed {
        screen.wait("images/txtBox.png", 10);
        screen.click("images/txtBox.png");
        screen.type("karlokorisnik" + Key.ENTER);
        screen.type(Key.TAB);
        screen.type("hgrsdrgeshtyjfyjhrtcht" + Key.ENTER);
        screen.wait("images/btnPrijava.png", 10);
        screen.click("images/btnPrijava.png");

        screen.wait("images/btnDodaj.png", 10);
        screen.click("images/btnDodaj.png");

        screen.type("RACUN");
        screen.type(Key.TAB);
        screen.type("www.URL.com");
        screen.type(Key.TAB);
        screen.type("KORIME");

        screen.wait("images/btnGeneriraj.png", 10);
        screen.click("images/btnGeneriraj.png");
        screen.wait("images/btnDodajRacun.png", 10);
        screen.click("images/btnDodajRacun.png");
        screen.wait("images/btnOK.png", 10);
        screen.click("images/btnOK.png");

        screen.wait("images/testRacun.png", 10);
        screen.click("images/testRacun.png");
        screen.wait("images/btnUredi.png", 10);
        screen.click("images/btnUredi.png");

        screen.type("UREDENO");
        screen.type(Key.TAB);
        screen.type("www.UREDENO.com");
        screen.type(Key.TAB);
        screen.type("UREDENO");
        screen.wait("images/btnDodajRacun.png", 10);
        screen.click("images/btnDodajRacun.png");
        screen.wait("images/btnOK.png", 10);
        screen.click("images/btnOK.png");

        Assert.assertNotNull(screen.wait("images/glavniScreen.png", 15));
    }

    @Test
    public void testDeleteAccount() throws FindFailed {
        screen.wait("images/txtBox.png", 10);
        screen.click("images/txtBox.png");
        screen.type("karlokorisnik" + Key.ENTER);
        screen.type(Key.TAB);
        screen.type("hgrsdrgeshtyjfyjhrtcht" + Key.ENTER);
        screen.wait("images/btnPrijava.png", 10);
        screen.click("images/btnPrijava.png");

        screen.wait("images/btnDodaj.png", 10);
        screen.click("images/btnDodaj.png");

        screen.type("BRISI");
        screen.type(Key.TAB);
        screen.type("www.ZABRISANJE.com");
        screen.type(Key.TAB);
        screen.type("KORIME");

        screen.wait("images/btnGeneriraj.png", 10);
        screen.click("images/btnGeneriraj.png");
        screen.wait("images/btnDodajRacun.png", 10);
        screen.click("images/btnDodajRacun.png");
        screen.wait("images/btnOK.png", 10);
        screen.click("images/btnOK.png");

        screen.wait("images/brisanjeRacun.png", 10);
        screen.click("images/brisanjeRacun.png");
        screen.wait("images/btnIzbrisi.png", 10);
        screen.click("images/btnIzbrisi.png");

        Assert.assertNotNull(screen.wait("images/glavniScreen.png", 15));
    }

    @Test
    public void testRegistration() throws FindFailed {
        screen.wait("images/txtNisteReg.png", 10);
        screen.click("images/txtNisteReg.png");

        screen.wait("images/txtBox.png", 10);
        screen.click("images/txtBox.png");
        int vrijeme = LocalDateTime.now().getSecond();
        int vrijeme2 = LocalDateTime.now().getMinute();
        screen.type("noviKorisnik" + vrijeme + vrijeme2);
        screen.type(Key.TAB);
        screen.type("r6hhu5678ir6k7u56erdh56gr");
        screen.type(Key.TAB);
        screen.type("r6hhu5678ir6k7u56erdh56gr");

        screen.wait("images/Reg2.png", 10);
        screen.click("images/Reg2.png");
        screen.wait("images/btnOK.png", 10);
        screen.click("images/btnOK.png");
        Assert.assertNotNull(screen.wait("images/btnPrijava.png", 15));
    }

    @After
    public void tearDown() {
        System.out.println("teardown");

        try {
            screen.wait("images/btnZatvori.png", 10);
        } catch (FindFailed e) {
            throw new RuntimeException(e);
        }
        try {
            screen.click("images/btnZatvori.png");
        } catch (FindFailed e) {
            throw new RuntimeException(e);
        }

        passwordium.closeByKey(1000);

    }
}
