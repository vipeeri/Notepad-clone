**Aihe:** Tekstieditori. Toteutetaan yksinkertainen tekstieditori eli notepad-kopio. 

**Käyttäjät:** Ei rajoituksia.

**Käyttäjien toiminnot:**
- Tekstin syöttäminen, sen muokkaaminen (alleviivaus, fontin ja teeman vaihto, lihavointi) tallennus ja tekstitiedostojen avaaminen.

**Rakennekuvaus:**
Tekstieditori koostuu kymmenestä eri luokasta, joista logiikkaan kuuluvat toiminnot-paketissa olevat luokat. Tekstieditori-pakettiin kuuluu Main- ja Tekstieditori-luokka, joista viimeisin jakaa käyttäjän valitsemia toiminnallisuuksia toiminnot-paketissa oleviin luokkiin.

Käyttäjä voi antaa komentoja GUI-luokasta, johon Tekstieditori-luokka sitoo kaikki käytettävissä olevat toiminnot.


**Käyttöohjeet**
Tekstieditori on yksinkertainen työkalu tekstinkäsittelyä varten.
Editorista löytyy 3 valikkoa; Tiedosto, Muokkaa ja Muotoile. Muotoile-valikosta voidaan muokata joko tekstiä tai itse editoria. Haluttu teksti voidaan lihavoida, alleviivata tai vaihtaa sen fonttia.
Ohjelmiston tausta- ja tekstiväriä voidaan vaihtaa teemojen mukaan. Tällä hetkellä teemoja löytyy kaksi; punainen ja tumma.
Muokkaa-valikosta voidaan kopioida, leikata tai liittää tekstiä. Nämä toimivat mmyös pikanäppäimillä (CTRL+X/C/V).
Tiedosto-valikosta tuotettu teksti voidaan tallentaa käyttäjän haluamaan hakemistoon. Tästä valikosta voidaan myös avata käyttäjän valitsema tekstitiedosto.
Suljettaessa editoria käyttäjältä kysytään haluataanko tehdyt muokkaukset tallentaa, jos tallentamattomia muutoksia havaitaan.

![Luokkakaavio](https://github.com/vipeeri/Tekstieditori/blob/master/dokumentaatio/luokkakaavio.png)
![SekvenssiKaavio1](https://github.com/vipeeri/Tekstieditori/blob/master/dokumentaatio/sekvenssikaavioavaa.png)
![Sekvenssikaavio2](https://github.com/vipeeri/Tekstieditori/blob/master/dokumentaatio/sekvenssikaaviotallenna.png)
![Sekvenssikaavio3](https://github.com/vipeeri/Tekstieditori/blob/master/dokumentaatio/sekvenssikaaviofontti.png)
![Sekvenssikaavio4](https://github.com/vipeeri/Tekstieditori/blob/master/dokumentaatio/sekvenssikaaviolihavoi.png)
