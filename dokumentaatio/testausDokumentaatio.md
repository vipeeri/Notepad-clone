# Testausdokumentaatio
-----
Tallennus-luokan tallennaNimella-metodia ei ole testattu automaattisesti. Käsin metodia testattiin antamalla tiedostonimelle erilaisia syötteitä tai ei lainkaan niitä. Lisäksi tarkistettiin tallennetun tiedoston sisältö, niin että se vastaisi sitä mitä käyttäjä on siihen syöttänyt. Metodissa ei ilmennyt virheitä, vaan se toimii toivotulla tavalla.
Samaisen luokan tallennaVanha-metodia on myös testattu ainoastaan käsin. Testaukseen kuului erilaistan muokkausten tai niiden tekemättä jättämisen vaikutuksia metodin toimintaan. Ainoat ongelmat tulivat, jos käyttäjä valitsi ohjelmaa suljettaessa haluavansa tallentaa tekstin, ja sen jälkee peruuttavansa valintansa hakemistoa valittaessa; ohjelma sulkeutui silloin tallentamatta. Nyt metodi toimii toivotulla tavalla.
Tallennus-luokan tarkistajaTallennaVanha-metodi on niin ikään testattu käsin. Metodi luotiin käsittelemään ohjelman sulkemista koskevat erilaiset tilanteet, kuten suljetaanko ohjelma, jos tekstiä ei ole syötetty, eikä tiedostoa ole avattu (tiedoston nimi on tyhjä).
Metodia testattiin myös erilaisilla syötteillä ja yhdistämällä siihen ConfirmDialogin YES/NO-nappuloiden paineluja eri tilanteissa.

