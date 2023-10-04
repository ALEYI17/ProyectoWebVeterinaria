package com.vetcare.proyecto.entities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.vetcare.proyecto.repository.ClienteRepositorio;
import com.vetcare.proyecto.repository.MascotaRepository;
import com.vetcare.proyecto.repository.MedicamentoRepositorio;
import com.vetcare.proyecto.repository.TratamientoRepositorio;
import com.vetcare.proyecto.repository.VeterinarioRepositorio;

import jakarta.transaction.Transactional;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Controller
@Transactional
public class databaseInit implements ApplicationRunner{


    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    VeterinarioRepositorio veterinarioRepositorio;

    @Autowired
    MedicamentoRepositorio medicamentoRepositorio;

    @Autowired
    TratamientoRepositorio tratamientoRepositorio;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        veterinarioRepositorio.save(new Veterinario("prueba","123", "123", "Nose", "Nose"));
        veterinarioRepositorio.save(new Veterinario("Lynelle Charsley", "9045730128", "nH6?tI)#e", "Imagenología", "https://images.ecestaticos.com/ciN9hN7qsu5JOcrGdMngWhCHs8Y=/0x70:1716x1040/1200x1200/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F8db%2F8b6%2Faa5%2F8db8b6aa54b585253e15f79a68447aeb.jpg"));
        veterinarioRepositorio.save(new Veterinario("Ianthe Jordine", "1443103554", "iB7,*K+Pi6a1q", "Rehabilitación", "https://drsaludcompany.cl/wp-content/uploads/elementor/thumbs/Javiera-2-scaled-pmum1xcvznx9anbzo274xlnjldwwsf2p2usg9ra89k.jpg"));
        veterinarioRepositorio.save(new Veterinario("Jayme Novotne", "3844360055", "zF1%7D9~f", "Oncología", "https://yt3.googleusercontent.com/ytc/APkrFKYQtHv2GYhbAQkrTRknWk6YVrDLLZk1YovsUcT0Aw=s900-c-k-c0x00ffffff-no-rj"));
        veterinarioRepositorio.save(new Veterinario("Harrietta Wheatcroft", "9928747656", "fV5.}6BrqQ+Ma&+", "Rehabilitación", "https://ic.c4assets.com/brands/the-good-doctor/b24d15b7-bba0-4939-bf45-e893dd5d46fa.jpg?interpolation=progressive-bicubic&output-format=jpeg&output-quality=90{&resize}"));
        veterinarioRepositorio.save(new Veterinario("Clem Brewers", "3306814411", "oK6*e`jYxEC=T}O@", "Oncología", "https://i.pinimg.com/originals/11/97/09/119709a6e0e53e358a6b783c300885eb.jpg"));
        veterinarioRepositorio.save(new Veterinario("Corry Yannoni", "8286795345", "sE4>f<r}Vrv", "Oncología", "https://tecolotito.elsiglodetorreon.com.mx/cdn-cgi/image/format=auto,width=1024/i/2009/07/139879.jpeg"));
        veterinarioRepositorio.save(new Veterinario("Xavier Brislen", "9640373723", "rY1@yb'~", "Oncología", "https://media.istockphoto.com/id/1468678629/photo/portrait-healthcare-and-tablet-with-a-doctor-woman-at-work-in-a-hospital-for-research-or.webp?b=1&s=170667a&w=0&k=20&c=H9w4bMoP3WXY178SVYmZsZsSCaTJoVLRMnSLPd3L3OE="));
        veterinarioRepositorio.save(new Veterinario("Pooh Geindre", "2352482910", "fE6@?)q~~_", "Fisioterapia", "https://www.leasurgery.co.uk/media/content/images/doctor.jpg"));
        veterinarioRepositorio.save(new Veterinario("Nobe Larter", "2064009404", "vG5(4c~Np`qYZ0", "Rehabilitación", "https://www.beaumont.org/images/default-source/primary-care/getting-to-know-doctor.jpg?sfvrsn=cc08ede2_0"));
        veterinarioRepositorio.save(new Veterinario("Yves Chittem", "6817346042", "eK3})<d`fC", "Fisioterapia", "https://www.pasadenahealthcenter.com/site/wp-content/uploads/2018/01/doctor.jpg"));
        veterinarioRepositorio.save(new Veterinario("Casie Gawkes", "7280532372", "uB8!1!c)fNh7Phe", "Cirugía", "https://medimap.ca/wp-content/uploads/2022/10/iStock-1193303828.jpg"));


        clienteRepositorio.save(new Cliente("5602222623501237","Crin Dottridge","cdottridge0@bravesites.com","184-683-8032"));
        clienteRepositorio.save(new Cliente("5610426064728825","Meghan Vain","mvain1@indiegogo.com","253-723-4589"));
        clienteRepositorio.save(new Cliente("5602248031401652","Darci Condie","dcondie2@blogtalkradio.com","755-993-2472"));
        clienteRepositorio.save(new Cliente("5610882771911973","Bernard Sackes","bsackes3@ca.gov","876-141-1589"));
        clienteRepositorio.save(new Cliente("374288553824805","Cully Matas","cmatas4@cdc.gov","764-541-3379"));
        clienteRepositorio.save(new Cliente("374288603248310","Corinne Nerne","cnerne5@time.com","541-955-9935"));
        clienteRepositorio.save(new Cliente("5610380149596485","Morgan Bernolet","mbernolet6@illinois.edu","841-465-7544"));
        clienteRepositorio.save(new Cliente("372301484707619","Yolane Thistleton","ythistleton7@ustream.tv","432-406-7458"));
        clienteRepositorio.save(new Cliente("372491765111308","Minerva Ashurst","mashurst8@list-manage.com","424-131-7675"));
        clienteRepositorio.save(new Cliente("375368923381238","Kerrin Pioch","kpioch9@hibu.com","367-259-8444"));
        clienteRepositorio.save(new Cliente("5602236196117023","Dominica Rosenfarb","drosenfarba@wordpress.com","277-852-9960"));
        clienteRepositorio.save(new Cliente("374283409761582","Valina Baggott","vbaggottb@angelfire.com","649-847-5802"));
        clienteRepositorio.save(new Cliente("374283395896384","Dagny Davidow","ddavidowc@hexun.com","970-778-5934"));
        clienteRepositorio.save(new Cliente("5602257500781486","Brande Caulkett","bcaulkettd@addthis.com","865-170-4691"));
        clienteRepositorio.save(new Cliente("5602228222398925","Allx Winship","awinshipe@biblegateway.com","595-323-6135"));
        clienteRepositorio.save(new Cliente("5602226925786347","Miles Frany","mfranyf@cbsnews.com","898-945-8824"));
        clienteRepositorio.save(new Cliente("374288095910500","Jill Goodbourn","jgoodbourng@pcworld.com","742-331-6722"));
        clienteRepositorio.save(new Cliente("374283780451274","Toinette Jerams","tjeramsh@github.io","749-653-5728"));
        clienteRepositorio.save(new Cliente("371457311064847","Erie Gobel","egobeli@arizona.edu","752-544-5760"));
        clienteRepositorio.save(new Cliente("376076868622123","Jenny Giovani","jgiovanij@unesco.org","179-585-6376"));
        clienteRepositorio.save(new Cliente("5602236327277357","Marge Malec","mmaleck@squidoo.com","277-638-5413"));
        clienteRepositorio.save(new Cliente("5602256801682385","Kile Dumphy","kdumphyl@marketwatch.com","819-548-8883"));
        clienteRepositorio.save(new Cliente("5602211891763355","Gipsy Archbould","garchbouldm@cnet.com","402-763-3570"));
        clienteRepositorio.save(new Cliente("5602216928829962","Vite Hugonin","vhugoninn@bizjournals.com","496-363-9148"));
        clienteRepositorio.save(new Cliente("349859054227730","Eric Withringten","ewithringteno@wired.com","305-521-8009"));
        clienteRepositorio.save(new Cliente("5602245781671724","Thorpe Terlinden","tterlindenp@mapquest.com","953-143-7079"));
        clienteRepositorio.save(new Cliente("374288205504045","Twyla Balnaves","tbalnavesq@netvibes.com","959-269-8991"));
        clienteRepositorio.save(new Cliente("5602227303518773","Trefor Calvard","tcalvardr@comsenz.com","630-772-9173"));
        clienteRepositorio.save(new Cliente("371866700185759","Reeba Maleham","rmalehams@vinaora.com","887-641-8220"));
        clienteRepositorio.save(new Cliente("5602243092633558","Vivianne Burnes","vburnest@sun.com","917-284-2302"));
        clienteRepositorio.save(new Cliente("5602250389738271","Barrie Digby","bdigbyu@youtu.be","946-104-8669"));
        clienteRepositorio.save(new Cliente("372301026384687","Torey Barratt","tbarrattv@theglobeandmail.com","619-619-3110"));
        clienteRepositorio.save(new Cliente("374283613945351","Any Tomkys","atomkysw@slate.com","865-592-2761"));
        clienteRepositorio.save(new Cliente("5610858708657871","Boy Kelk","bkelkx@answers.com","525-467-7043"));
        clienteRepositorio.save(new Cliente("5602251568175244","Codie Libreros","clibrerosy@deliciousdays.com","226-171-3199"));
        clienteRepositorio.save(new Cliente("5610955261359885","Laughton Eagger","leaggerz@cloudflare.com","622-956-4799"));
        clienteRepositorio.save(new Cliente("374622169164786","Stafford Rault","srault10@tuttocitta.it","135-182-9561"));
        clienteRepositorio.save(new Cliente("5602237137080817","Talya Foulkes","tfoulkes11@woothemes.com","547-878-5826"));
        clienteRepositorio.save(new Cliente("5602241958853815","Elvyn Cowlin","ecowlin12@telegraph.co.uk","418-850-4148"));
        clienteRepositorio.save(new Cliente("374622160531629","Philippine O'Currane","pocurrane13@forbes.com","502-883-2935"));
        clienteRepositorio.save(new Cliente("5602236989402921","Romy Campione","rcampione14@mit.edu","241-218-0964"));
        clienteRepositorio.save(new Cliente("337941682156335","Antonetta Sackur","asackur15@oakley.com","684-637-5888"));
        clienteRepositorio.save(new Cliente("344247442909448","Rebecka Boscher","rboscher16@tmall.com","969-358-4619"));
        clienteRepositorio.save(new Cliente("347013784985041","Renaldo Earp","rearp17@cisco.com","176-557-9490"));
        clienteRepositorio.save(new Cliente("5602231812797159","Dynah Benoiton","dbenoiton18@disqus.com","411-282-3571"));
        clienteRepositorio.save(new Cliente("5602258345383595","Gerri Caswall","gcaswall19@de.vu","698-857-2334"));
        clienteRepositorio.save(new Cliente("5602250834814263","Brewster Zolini","bzolini1a@nps.gov","528-620-3271"));
        clienteRepositorio.save(new Cliente("5610532474297101","Kinna Manifield","kmanifield1b@dropbox.com","973-697-0539"));
        clienteRepositorio.save(new Cliente("5610852357387591","Dianna Karlsen","dkarlsen1c@latimes.com","540-601-7660"));
        clienteRepositorio.save(new Cliente("5602211492454834","Carolann Larway","clarway1d@xinhuanet.com","792-880-8946"));
        clienteRepositorio.save(new Cliente("337941183735876","Maxi Lippiatt","mlippiatt1e@hhs.gov","936-191-3078"));
        clienteRepositorio.save(new Cliente("5602215392755562","Kandy Colleck","kcolleck1f@cisco.com","151-607-4890"));
        clienteRepositorio.save(new Cliente("5602255158197641","Tim MacRury","tmacrury1g@g.co","713-448-1209"));
        clienteRepositorio.save(new Cliente("5602248745161923","Violet Gateman","vgateman1h@aol.com","577-938-8690"));
        clienteRepositorio.save(new Cliente("373693584818414","Lewie Abramovitch","labramovitch1i@hp.com","471-691-1009"));
        clienteRepositorio.save(new Cliente("5602221136058503","Alejandrina Bean","abean1j@cornell.edu","676-158-3979"));
        clienteRepositorio.save(new Cliente("337941486437790","Elfrida Nyles","enyles1k@google.es","324-688-2436"));
        clienteRepositorio.save(new Cliente("5602214027388741","Kevina Lidgard","klidgard1l@ovh.net","193-711-9722"));
        clienteRepositorio.save(new Cliente("374283713874493","Ynes Blanpein","yblanpein1m@stumbleupon.com","345-527-2932"));
        clienteRepositorio.save(new Cliente("5610681241437175","Janna Laurentin","jlaurentin1n@shinystat.com","529-523-1286"));
        clienteRepositorio.save(new Cliente("345095084253602","Brenden Kaye","bkaye1o@epa.gov","229-474-9497"));
        clienteRepositorio.save(new Cliente("337941871380605","Angelico Chrisp","achrisp1p@yahoo.com","734-989-5586"));
        clienteRepositorio.save(new Cliente("374283736974890","Talbot Swiggs","tswiggs1q@yolasite.com","773-220-3879"));
        clienteRepositorio.save(new Cliente("370376526960899","Rena Dufaur","rdufaur1r@g.co","358-609-0914"));
        clienteRepositorio.save(new Cliente("5610427870181126","Ki Lemasney","klemasney1s@upenn.edu","207-903-3838"));
        clienteRepositorio.save(new Cliente("5610179003571679","Niels Marcome","nmarcome1t@telegraph.co.uk","823-979-9873"));
        clienteRepositorio.save(new Cliente("5602230114215191","Ellie Dewberry","edewberry1u@feedburner.com","736-699-9985"));
        clienteRepositorio.save(new Cliente("5602239237848887","Rolf Naisby","rnaisby1v@g.co","211-541-9539"));
        clienteRepositorio.save(new Cliente("5602210275331128","Cyndy Hickeringill","chickeringill1w@mapy.cz","910-787-6401"));
        clienteRepositorio.save(new Cliente("337941787208718","Theresa Ferretti","tferretti1x@adobe.com","816-134-9141"));
        clienteRepositorio.save(new Cliente("372301634648010","Sibyl Shaul","sshaul1y@alibaba.com","491-948-9194"));
        clienteRepositorio.save(new Cliente("374622442361332","Cilka Ludron","cludron1z@bloglovin.com","694-686-2013"));
        clienteRepositorio.save(new Cliente("374622658526123","Lou Shenfisch","lshenfisch20@typepad.com","406-757-7077"));
        clienteRepositorio.save(new Cliente("5602248485451823","Bethanne Brailey","bbrailey21@mozilla.com","583-881-6737"));
        clienteRepositorio.save(new Cliente("5610909250283937","Margalo Ferrarese","mferrarese22@si.edu","400-362-6145"));
        clienteRepositorio.save(new Cliente("374283728487935","Pierre Mithon","pmithon23@washingtonpost.com","385-291-0527"));
        clienteRepositorio.save(new Cliente("374288120809008","Umberto Robillard","urobillard24@omniture.com","918-747-7575"));
        clienteRepositorio.save(new Cliente("374283748231529","Byrann Gerner","bgerner25@bluehost.com","801-506-2404"));
        clienteRepositorio.save(new Cliente("374622506140531","Filbert Celler","fceller26@patch.com","125-191-3627"));
        clienteRepositorio.save(new Cliente("374283066882143","Bealle Darville","bdarville27@lycos.com","476-311-0186"));
        clienteRepositorio.save(new Cliente("373486810973230","Blakelee Spohr","bspohr28@wikipedia.org","690-252-0570"));
        clienteRepositorio.save(new Cliente("5602256327479803","Shannah Astley","sastley29@usatoday.com","580-107-4445"));
        clienteRepositorio.save(new Cliente("374094258850107","Shirley Nulty","snulty2a@aol.com","149-815-5253"));
        clienteRepositorio.save(new Cliente("5602219125378049","Aubree Baxstair","abaxstair2b@ezinearticles.com","278-584-9213"));
        clienteRepositorio.save(new Cliente("337941926935999","Evan Colwill","ecolwill2c@mac.com","660-100-0788"));
        clienteRepositorio.save(new Cliente("5602220110644916","Andree Baff","abaff2d@zdnet.com","125-457-0257"));
        clienteRepositorio.save(new Cliente("5602235959575344","Traci Swetmore","tswetmore2e@businessweek.com","546-724-8953"));
        clienteRepositorio.save(new Cliente("5602227595000324","Isabella Currington","icurrington2f@diigo.com","109-679-2810"));
        clienteRepositorio.save(new Cliente("5610913732952481","Levy Dewsnap","ldewsnap2g@vimeo.com","862-835-2184"));
        clienteRepositorio.save(new Cliente("5602244926501813","Bee Hourahan","bhourahan2h@washingtonpost.com","696-207-0601"));
        clienteRepositorio.save(new Cliente("5602217770517218","Sandi Beever","sbeever2i@whitehouse.gov","737-133-4688"));
        clienteRepositorio.save(new Cliente("337941066302331","Fania Ksandra","fksandra2j@howstuffworks.com","250-811-2970"));
        clienteRepositorio.save(new Cliente("5610044013251953","Silvanus Grief","sgrief2k@hexun.com","106-713-7788"));
        clienteRepositorio.save(new Cliente("5602228361363631","Franni Harpur","fharpur2l@wiley.com","879-796-3059"));
        clienteRepositorio.save(new Cliente("337941843386169","Orsola Lowder","olowder2m@wikispaces.com","391-297-9679"));
        clienteRepositorio.save(new Cliente("374622310305783","Hephzibah Roma","hroma2n@vistaprint.com","203-855-3134"));
        clienteRepositorio.save(new Cliente("374288810042795","Ariella Hodgin","ahodgin2o@is.gd","281-616-0109"));
        clienteRepositorio.save(new Cliente("374288744874230","Hubey Worssam","hworssam2p@sourceforge.net","718-350-9624"));
        clienteRepositorio.save(new Cliente("5602235713110313","Gillie Meegin","gmeegin2q@house.gov","922-861-3358"));
        clienteRepositorio.save(new Cliente("374283828690503","Cassandre Baylay","cbaylay2r@go.com","891-785-3194"));

        mascotaRepository.save(new Mascota("Quinta","Siamese",14,5.0,"Cistitis","https://static01.nyt.com/images/2021/09/14/science/07CAT-STRIPES/07CAT-STRIPES-superJumbo.jpg?quality=75&auto=webp"));
        mascotaRepository.save(new Mascota("Lolly","Persian",18,4.9,"Perionitis","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Ranice","Lykoi",10,4.3,"Virus de la leucemia felina","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Mattheus","Siamese",9,4.4,"Virus de la leucemia felina","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Cly","Maine Coon",15,4.4,"Cistitis","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Olag","Siamese",6,5.8,"Virus de la inmunodeficiencia felina","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Dix","Persian",15,5.7,"Otitis","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Gilberto","ceilán",2,4.5,"cojo","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Derek","Lykoi",17,3.2,"Conjuntivitis","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Cassandra","Lykoi",19,4.0,"cojo","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Burty","Himalayo",6,4.9,"Conjuntivitis","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Xavier","Himalayo",2,5.3,"cojo","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Sidonnie","Siamese",20,4.4,"Perionitis","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Biddie","ceilán",16,4.2,"Rabia","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Trixi","Lykoi",6,5.0,"Conjuntivitis","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Angie","Siamese",11,5.5,"cojo","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Bentley","Himalayo",9,4.7,"cojo","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Fanchon","Persian",16,5.8,"cojo","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Welsh","Siamese",17,5.9,"Virus de la leucemia felina","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Aarika","nebelung",10,4.2,"Perionitis","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Kristo","Siamese",16,5.1,"Virus de la inmunodeficiencia felina","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Beckie","ceilán",11,5.2,"Rabia","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Gael","Maine Coon",20,3.0,"Rabia","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Ruby","Himalayo",6,3.6,"Rabia","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Gustave","Siamese",7,4.5,"Otitis","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Becka","Lykoi",15,4.9,"Perionitis","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Avril","nebelung",11,3.3,"Otitis","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Perren","Siamese",18,3.8,"Perionitis","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Hagan","Maine Coon",15,5.8,"Rabia","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Spike","nebelung",16,5.6,"cojo","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Beulah","Maine Coon",3,4.5,"Virus de la leucemia felina","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Alfie","Himalayo",14,3.6,"Cistitis","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Paquito","Persian",5,3.1,"Conjuntivitis","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Langsdon","British shorthair",10,4.9,"Otitis","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Fran","British shorthair",6,6.0,"cojo","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Guenna","nebelung",3,3.6,"Conjuntivitis","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Harlen","Maine Coon",10,3.4,"Virus de la inmunodeficiencia felina","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Jorie","nebelung",14,3.6,"Cistitis","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Bibbie","Siamese",7,3.0,"Perionitis","https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg"));
        mascotaRepository.save(new Mascota("Fina","nebelung",5,4.4,"Virus de la leucemia felina","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Kimmie","americano de pelo corto",6,4.4,"Rabia","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Vernen","nebelung",15,5.5,"Cistitis","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Zorine","Persian",11,4.3,"Cistitis","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Adams","americano de pelo corto",3,5.0,"Cistitis","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Gregory","Lykoi",12,5.6,"Conjuntivitis","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Cherilyn","ceilán",9,3.5,"Rabia","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Valerie","Lykoi",3,4.7,"Cistitis","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Maurie","Persian",1,5.7,"Otitis","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Franky","Siamese",4,3.8,"Virus de la leucemia felina","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Syman","Siamese",20,5.4,"Cistitis","https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg"));
        mascotaRepository.save(new Mascota("Veda","nebelung",19,3.2,"Rabia","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Uta","ceilán",20,5.9,"Cistitis","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Clemente","nebelung",14,3.6,"Conjuntivitis","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Turner","ceilán",2,5.2,"Rabia","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Eliza","ceilán",1,5.3,"cojo","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Emanuel","Siamese",12,4.0,"Perionitis","https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg"));
        mascotaRepository.save(new Mascota("Zarah","Maine Coon",3,4.0,"Virus de la inmunodeficiencia felina","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Wallie","British shorthair",5,3.2,"Virus de la inmunodeficiencia felina","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Micheil","americano de pelo corto",18,3.2,"Otitis","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Joanie","Lykoi",7,4.4,"Virus de la leucemia felina","https://static01.nyt.com/images/2021/09/14/science/07CAT-STRIPES/07CAT-STRIPES-superJumbo.jpg?quality=75&auto=webp"));
        mascotaRepository.save(new Mascota("Jammal","nebelung",14,6.0,"Cistitis","https://static01.nyt.com/images/2021/09/14/science/07CAT-STRIPES/07CAT-STRIPES-superJumbo.jpg?quality=75&auto=webp"));
        mascotaRepository.save(new Mascota("Elsinore","ceilán",15,4.0,"cojo","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Carling","nebelung",18,4.5,"Perionitis","https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg"));
        mascotaRepository.save(new Mascota("Maybelle","British shorthair",1,5.6,"Cistitis","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Fairleigh","British shorthair",6,3.6,"Cistitis","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Alan","Persian",10,5.8,"Perionitis","https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg"));
        mascotaRepository.save(new Mascota("Kissie","Lykoi",1,4.9,"cojo","https://static01.nyt.com/images/2021/09/14/science/07CAT-STRIPES/07CAT-STRIPES-superJumbo.jpg?quality=75&auto=webp"));
        mascotaRepository.save(new Mascota("Allix","ceilán",10,3.8,"Cistitis","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Barbey","Persian",5,5.9,"Cistitis","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Nadya","Siamese",13,5.7,"Virus de la inmunodeficiencia felina","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Frazer","British shorthair",19,3.5,"Virus de la leucemia felina","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Correy","Siamese",8,3.2,"Otitis","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Amalita","Siamese",19,4.6,"Cistitis","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Eben","americano de pelo corto",1,3.9,"Otitis","https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg"));
        mascotaRepository.save(new Mascota("Bernita","Persian",20,4.0,"Cistitis","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Lyell","Lykoi",3,3.3,"Virus de la inmunodeficiencia felina","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Archer","americano de pelo corto",19,3.7,"cojo","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Marguerite","Siamese",7,3.5,"cojo","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Corissa","nebelung",17,4.4,"Virus de la leucemia felina","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Karia","Maine Coon",5,4.8,"Conjuntivitis","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Tallulah","Maine Coon",19,5.2,"cojo","https://static01.nyt.com/images/2021/09/14/science/07CAT-STRIPES/07CAT-STRIPES-superJumbo.jpg?quality=75&auto=webp"));
        mascotaRepository.save(new Mascota("Aimil","Maine Coon",14,4.7,"Rabia","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Berkie","Maine Coon",14,5.6,"Virus de la inmunodeficiencia felina","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Cyrill","nebelung",16,3.3,"Virus de la inmunodeficiencia felina","https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg"));
        mascotaRepository.save(new Mascota("Costa","Maine Coon",8,3.7,"Perionitis","https://static01.nyt.com/images/2021/09/14/science/07CAT-STRIPES/07CAT-STRIPES-superJumbo.jpg?quality=75&auto=webp"));
        mascotaRepository.save(new Mascota("Pattin","Siamese",16,5.1,"Virus de la inmunodeficiencia felina","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Merlina","ceilán",11,4.3,"Perionitis","https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg"));
        mascotaRepository.save(new Mascota("Vincents","Persian",10,4.5,"Cistitis","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Veronique","ceilán",20,5.6,"Rabia","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Ilka","British shorthair",4,4.2,"Perionitis","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Ilyssa","nebelung",9,5.8,"Rabia","https://greatcatsworldpark.com/wp-content/uploads/2019/01/Black-footed-Cat.jpg"));
        mascotaRepository.save(new Mascota("Georgy","British shorthair",3,5.2,"Conjuntivitis","https://static01.nyt.com/images/2021/09/14/science/07CAT-STRIPES/07CAT-STRIPES-superJumbo.jpg?quality=75&auto=webp"));
        mascotaRepository.save(new Mascota("Welsh","nebelung",19,4.4,"Cistitis","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Almeda","Lykoi",19,3.4,"Virus de la inmunodeficiencia felina","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Elberta","Siamese",20,5.6,"Otitis","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Sibilla","Siamese",6,5.2,"Virus de la leucemia felina","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Lotty","nebelung",20,5.8,"Virus de la inmunodeficiencia felina","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Danie","Maine Coon",14,3.9,"Perionitis","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Maddie","Himalayo",7,4.1,"cojo","https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg"));
        mascotaRepository.save(new Mascota("Aksel","Himalayo",18,5.3,"Virus de la inmunodeficiencia felina","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Janina","nebelung",16,3.9,"Virus de la inmunodeficiencia felina","https://static01.nyt.com/images/2021/09/14/science/07CAT-STRIPES/07CAT-STRIPES-superJumbo.jpg?quality=75&auto=webp"));
        mascotaRepository.save(new Mascota("Edgardo","ceilán",4,5.6,"Cistitis","https://greatcatsworldpark.com/wp-content/uploads/2019/01/Black-footed-Cat.jpg"));
        mascotaRepository.save(new Mascota("Jaye","Persian",6,3.4,"Cistitis","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Faunie","Himalayo",19,5.6,"cojo","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Emmy","Lykoi",19,3.5,"Conjuntivitis","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Tori","Persian",15,4.4,"Virus de la inmunodeficiencia felina","https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg"));
        mascotaRepository.save(new Mascota("Giselle","Lykoi",18,5.1,"Conjuntivitis","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Natividad","americano de pelo corto",18,4.7,"Virus de la leucemia felina","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Rollin","British shorthair",9,4.2,"Conjuntivitis","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Leeland","ceilán",7,3.9,"Conjuntivitis","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Waylin","nebelung",9,4.6,"Cistitis","https://greatcatsworldpark.com/wp-content/uploads/2019/01/Black-footed-Cat.jpg"));
        mascotaRepository.save(new Mascota("Riva","ceilán",13,4.4,"Cistitis","https://static01.nyt.com/images/2021/09/14/science/07CAT-STRIPES/07CAT-STRIPES-superJumbo.jpg?quality=75&auto=webp"));
        mascotaRepository.save(new Mascota("Gisela","nebelung",11,4.9,"Conjuntivitis","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Archaimbaud","ceilán",1,5.9,"Perionitis","https://static01.nyt.com/images/2021/09/14/science/07CAT-STRIPES/07CAT-STRIPES-superJumbo.jpg?quality=75&auto=webp"));
        mascotaRepository.save(new Mascota("Colman","Siamese",5,4.0,"cojo","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Leah","nebelung",14,3.2,"Perionitis","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Mal","ceilán",6,3.3,"Cistitis","https://i.pinimg.com/originals/3e/78/69/3e78692e30e89e6f1e2fe7b2da08054a.jpg"));
        mascotaRepository.save(new Mascota("Holli","British shorthair",14,4.8,"Otitis","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Gretta","americano de pelo corto",3,3.0,"Conjuntivitis","https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=0.670xw:1.00xh;0.167xw,0&resize=640:*"));
        mascotaRepository.save(new Mascota("Aile","Himalayo",4,4.0,"Cistitis","https://greatcatsworldpark.com/wp-content/uploads/2019/01/Black-footed-Cat.jpg"));
        mascotaRepository.save(new Mascota("Tanney","Siamese",14,5.2,"Otitis","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Mac","Siamese",16,4.0,"Virus de la inmunodeficiencia felina","https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg"));
        mascotaRepository.save(new Mascota("Karon","Lykoi",11,5.8,"Rabia","https://i.pinimg.com/originals/3e/78/69/3e78692e30e89e6f1e2fe7b2da08054a.jpg"));
        mascotaRepository.save(new Mascota("Raina","Lykoi",19,4.2,"Rabia","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Pen","Maine Coon",1,4.2,"Otitis","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Bel","British shorthair",20,3.6,"","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Griswold","Maine Coon",9,4.8,"Conjuntivitis","https://greatcatsworldpark.com/wp-content/uploads/2019/01/Black-footed-Cat.jpg"));
        mascotaRepository.save(new Mascota("Teddi","Siamese",20,3.5,"Virus de la inmunodeficiencia felina","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Robbin","ceilán",13,4.5,"cojo","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Norene","nebelung",18,5.6,"Cistitis","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Greer","Maine Coon",1,3.6,"Perionitis","https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg"));
        mascotaRepository.save(new Mascota("Melody","nebelung",3,5.3,"Perionitis","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Egan","americano de pelo corto",12,3.7,"Perionitis","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Aleda","ceilán",4,4.8,"Virus de la inmunodeficiencia felina","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Angeli","Himalayo",13,4.1,"Rabia","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Terrell","Lykoi",2,3.4,"Virus de la inmunodeficiencia felina","https://i.pinimg.com/originals/2b/20/7b/2b207be8d2aab17f099852b8c2df39ff.jpg"));
        mascotaRepository.save(new Mascota("Krystal","Lykoi",6,4.3,"cojo","https://greatcatsworldpark.com/wp-content/uploads/2019/01/Black-footed-Cat.jpg"));
        mascotaRepository.save(new Mascota("Florentia","British shorthair",16,3.9,"Otitis","https://i.pinimg.com/originals/3e/78/69/3e78692e30e89e6f1e2fe7b2da08054a.jpg"));
        mascotaRepository.save(new Mascota("Rustin","Lykoi",4,4.9,"Rabia","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Rawley","ceilán",13,4.8,"Virus de la inmunodeficiencia felina","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Waly","nebelung",9,4.8,"Virus de la inmunodeficiencia felina","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Laurella","Lykoi",3,5.6,"Virus de la inmunodeficiencia felina","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Crissie","nebelung",7,4.9,"Rabia","https://greatcatsworldpark.com/wp-content/uploads/2019/01/Black-footed-Cat.jpg"));
        mascotaRepository.save(new Mascota("Maura","Himalayo",10,3.0,"Virus de la inmunodeficiencia felina","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Mela","nebelung",19,5.6,"Perionitis","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Minne","ceilán",3,3.6,"Virus de la leucemia felina","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Dollie","Lykoi",4,3.8,"Cistitis","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Bathsheba","ceilán",19,4.1,"Virus de la leucemia felina","https://i.pinimg.com/originals/2b/20/7b/2b207be8d2aab17f099852b8c2df39ff.jpg"));
        mascotaRepository.save(new Mascota("Malina","americano de pelo corto",2,5.1,"cojo","https://greatcatsworldpark.com/wp-content/uploads/2019/01/Black-footed-Cat.jpg"));
        mascotaRepository.save(new Mascota("Concettina","ceilán",7,5.7,"Cistitis","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Brianne","ceilán",7,5.8,"Perionitis","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Myriam","Lykoi",7,4.4,"Conjuntivitis","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Dorey","British shorthair",20,3.4,"Conjuntivitis","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Leonardo","ceilán",1,3.5,"Conjuntivitis","https://i.pinimg.com/originals/3e/78/69/3e78692e30e89e6f1e2fe7b2da08054a.jpg"));
        mascotaRepository.save(new Mascota("Guthry","British shorthair",11,5.1,"Perionitis","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Estrella","Himalayo",1,5.1,"Otitis","https://greatcatsworldpark.com/wp-content/uploads/2019/01/Black-footed-Cat.jpg"));
        mascotaRepository.save(new Mascota("Travus","Maine Coon",13,5.1,"Cistitis","https://i.pinimg.com/originals/2b/20/7b/2b207be8d2aab17f099852b8c2df39ff.jpg"));
        mascotaRepository.save(new Mascota("Aldwin","americano de pelo corto",13,4.7,"Virus de la leucemia felina","https://i.pinimg.com/originals/3e/78/69/3e78692e30e89e6f1e2fe7b2da08054a.jpg"));
        mascotaRepository.save(new Mascota("Alida","nebelung",3,4.1,"Virus de la leucemia felina","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Ariana","British shorthair",5,4.5,"Rabia","https://i.pinimg.com/originals/3e/78/69/3e78692e30e89e6f1e2fe7b2da08054a.jpg"));
        mascotaRepository.save(new Mascota("Ellette","British shorthair",20,4.2,"Rabia","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Marmaduke","Maine Coon",19,3.3,"Rabia","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Bianca","British shorthair",6,3.5,"Virus de la inmunodeficiencia felina","https://greatcatsworldpark.com/wp-content/uploads/2019/01/Black-footed-Cat.jpg"));
        mascotaRepository.save(new Mascota("Thorstein","Maine Coon",2,5.0,"Cistitis","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Heath","americano de pelo corto",4,3.3,"","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Adria","Himalayo",15,3.5,"Rabia","https://i.pinimg.com/originals/2b/20/7b/2b207be8d2aab17f099852b8c2df39ff.jpg"));
        mascotaRepository.save(new Mascota("Carlotta","nebelung",11,3.2,"Perionitis","https://greatcatsworldpark.com/wp-content/uploads/2019/01/Black-footed-Cat.jpg"));
        mascotaRepository.save(new Mascota("Brietta","Maine Coon",4,3.5,"cojo","https://i.pinimg.com/originals/3e/78/69/3e78692e30e89e6f1e2fe7b2da08054a.jpg"));
        mascotaRepository.save(new Mascota("Cassey","Himalayo",2,4.5,"Otitis","https://hips.hearstapps.com/hmg-prod/images/russian-blue-royalty-free-image-1658451809.jpg?resize=1200:*"));
        mascotaRepository.save(new Mascota("Cam","Maine Coon",17,3.4,"Perionitis","https://greatcatsworldpark.com/wp-content/uploads/2019/01/Black-footed-Cat.jpg"));
        mascotaRepository.save(new Mascota("Josiah","Lykoi",11,5.7,"Virus de la leucemia felina","https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg"));
        mascotaRepository.save(new Mascota("Bennett","nebelung",3,4.7,"Virus de la inmunodeficiencia felina","https://i.pinimg.com/originals/3e/78/69/3e78692e30e89e6f1e2fe7b2da08054a.jpg"));
        mascotaRepository.save(new Mascota("Lawry","Lykoi",16,4.4,"Rabia","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Jazmin","ceilán",10,3.9,"Otitis","https://greatcatsworldpark.com/wp-content/uploads/2019/01/Black-footed-Cat.jpg"));
        mascotaRepository.save(new Mascota("Rosanna","nebelung",16,4.4,"Otitis","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Miof mela","Lykoi",16,3.5,"Conjuntivitis","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Cedric","nebelung",3,5.2,"cojo","https://i.pinimg.com/originals/2b/20/7b/2b207be8d2aab17f099852b8c2df39ff.jpg"));
        mascotaRepository.save(new Mascota("Annice","nebelung",12,4.1,"Rabia","https://greatcatsworldpark.com/wp-content/uploads/2019/01/Black-footed-Cat.jpg"));
        mascotaRepository.save(new Mascota("Hoyt","Maine Coon",7,3.9,"Conjuntivitis","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Trip","nebelung",11,5.4,"Conjuntivitis","https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg"));
        mascotaRepository.save(new Mascota("Ottilie","Siamese",6,4.7,"Virus de la inmunodeficiencia felina","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Isidoro","British shorthair",3,4.8,"","https://i.pinimg.com/originals/3e/78/69/3e78692e30e89e6f1e2fe7b2da08054a.jpg"));
        mascotaRepository.save(new Mascota("Nobie","Himalayo",3,4.5,"Rabia","https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg"));
        mascotaRepository.save(new Mascota("Esma","Persian",6,3.1,"Virus de la inmunodeficiencia felina","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Gerri","Siamese",1,5.7,"Otitis","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Arny","americano de pelo corto",15,4.6,"cojo","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Anallise","nebelung",11,6.0,"cojo","https://greatcatsworldpark.com/wp-content/uploads/2019/01/Black-footed-Cat.jpg"));
        mascotaRepository.save(new Mascota("Teresina","British shorthair",2,4.9,"Virus de la inmunodeficiencia felina","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Kalie","Persian",12,3.6,"Perionitis","https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg"));
        mascotaRepository.save(new Mascota("Alvera","Lykoi",4,5.3,"Virus de la inmunodeficiencia felina","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Jeremy","ceilán",10,5.5,"Virus de la inmunodeficiencia felina","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Seka","British shorthair",6,4.5,"Perionitis","https://i.pinimg.com/originals/3e/78/69/3e78692e30e89e6f1e2fe7b2da08054a.jpg"));
        mascotaRepository.save(new Mascota("Viva","Maine Coon",20,5.8,"Cistitis","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Lanae","nebelung",14,4.1,"Virus de la leucemia felina","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Jerri","British shorthair",14,3.1,"Perionitis","https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_3x4.jpg"));
        mascotaRepository.save(new Mascota("Dionisio","British shorthair",2,3.6,"cojo","https://i.natgeofe.com/k/ad9b542e-c4a0-4d0b-9147-da17121b4c98/MOmeow1_square.png"));
        mascotaRepository.save(new Mascota("Faustina","nebelung",12,5.5,"Perionitis","https://catastic.b-cdn.net/wp-content/uploads/2019/01/photo-1518791841217-8f162f1e1131.jpg"));
        mascotaRepository.save(new Mascota("Chuck","Siamese",18,5.7,"Virus de la leucemia felina","https://www.litter-robot.com/media/blog/alex-meier-siamese.jpg"));
        mascotaRepository.save(new Mascota("Shina","Siamese",15,4.1,"Otitis","https://assets-jpcust.jwpsrv.com/thumbnails/1lgumtzy-720.jpg"));
        mascotaRepository.save(new Mascota("Veronique","Himalayo",14,3.2,"Rabia","https://greatcatsworldpark.com/wp-content/uploads/2019/01/Black-footed-Cat.jpg"));

        List<Cliente>  clientes = clienteRepositorio.findAll();
        List <Mascota> mascotas = mascotaRepository.findAll();
        Integer j=0;
        for(int i = 0 ;i<mascotas.size();i += 2){

            mascotas.get(i).setCliente(clientes.get(j));
            mascotas.get(i+1).setCliente(clientes.get(j));
            j++;

        }

        for (int i = 0; i < 10; i++) {
            Tratamiento tratamiento = new Tratamiento(new Date(), 100); // Debes proporcionar la fecha y el precio correctos aquí
            tratamientoRepositorio.save(tratamiento);
        }

        leerMedicamentosDesdeExcel();

        List<Tratamiento> tratamientos = tratamientoRepositorio.findAll();
        List<Medicamento> medicamentos = medicamentoRepositorio.findAll();
        j = 0;
        for(int i = 0 ; i <medicamentos.size(); i ++){
            if(tratamientos.get(j).getId() == 10){
                medicamentos.get(i).setTratamiento(tratamientos.get(j));
                j = 0;
            }
            else{
                medicamentos.get(i).setTratamiento(tratamientos.get(j));
                j++;
            }
            
            
        }
    }


    public void leerMedicamentosDesdeExcel() throws IOException {
        

        try (FileInputStream archivo = new FileInputStream("MEDICAMENTOS_VETERINARIA.xlsx");
             Workbook workbook = new XSSFWorkbook(archivo)) {

            Sheet hoja = workbook.getSheetAt(0); // Suponiendo que los datos están en la primera hoja

            Iterator<Row> filaIterator = hoja.iterator();
            filaIterator.next(); // Saltar la primera fila (encabezados)

            while (filaIterator.hasNext()) {
                Row fila = filaIterator.next();
                Iterator<Cell> celdaIterator = fila.iterator();

                String nombre = celdaIterator.next().getStringCellValue();
                double precioVenta = celdaIterator.next().getNumericCellValue();
                double precioCompra = celdaIterator.next().getNumericCellValue();
                int unidadesDisponibles = (int) celdaIterator.next().getNumericCellValue();
                int unidadesVendidas = (int) celdaIterator.next().getNumericCellValue();

                // Crea un nuevo objeto Medicamento y agrégalo a la lista
                Medicamento medicamento = new Medicamento(nombre, precioVenta, precioCompra, unidadesDisponibles, unidadesVendidas);
                medicamentoRepositorio.save(medicamento);
            }
        }

        
    }
    
}
