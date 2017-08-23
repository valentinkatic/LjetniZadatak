drop database if exists narucivanje_hrane;
create database narucivanje_hrane default character set utf8;
use narucivanje_hrane;

create table restoran(
sifra int primary key not null auto_increment,
naziv varchar(50),
adresa varchar(50),
grad varchar(50),
kontakt_broj varchar(15),
email varchar(50),
lozinka char(32),
slika blob,
obrisano boolean default false
);

create table korisnik(
sifra int primary key not null auto_increment,
ime varchar(50),
prezime varchar(50),
email varchar(50),
lozinka char(32),
kontakt_broj varchar(15),
obrisano boolean default false
);

create table adresa_dostave(
sifra int primary key not null auto_increment,
ulica varchar(50),
kucni_broj varchar(3),
grad varchar(50),
korisnik int,
obrisano boolean default false
);

create table kategorija_jela(
sifra int primary key not null auto_increment,
naziv varchar(50),
obrisano boolean default false
);

create table restoran_kategorija(
restoran int,
kategorija_jela int
);

create table jelo(
sifra int primary key not null auto_increment,
naziv varchar(50),
sastojci varchar(150),
cijena decimal(5,2),
slika blob,
kategorija_jela int,
restoran int,
obrisano boolean default false
);

create table narudzba(
sifra int primary key not null auto_increment,
restoran int,
korisnik int,
vrijeme_narudzbe datetime,
adresa_dostave int not null,
obrisano boolean default false
);

create table narudzba_jelo(
narudzba int,
jelo int,
cijena decimal(5,2) not null,
kolicina int not null
);

alter table restoran_kategorija add foreign key (kategorija_jela) references kategorija_jela(sifra);
alter table restoran_kategorija add foreign key (restoran) references restoran(sifra);
alter table adresa_dostave add foreign key (korisnik) references korisnik(sifra);
alter table jelo add foreign key (kategorija_jela) references kategorija_jela(sifra);
alter table narudzba add foreign key (restoran) references restoran(sifra);
alter table narudzba add foreign key (korisnik) references korisnik(sifra);
alter table narudzba_jelo add foreign key (narudzba) references narudzba(sifra);
alter table narudzba_jelo add foreign key (jelo) references jelo(sifra);


insert into restoran (naziv,adresa,grad,kontakt_broj,email,lozinka) values ("Karaka","Kneza Trpimira 16", "Osijek", "031203500", "karaka@mail.com", "karaka123");
insert into restoran (naziv,adresa,grad,kontakt_broj,email,lozinka) values ("Oliva","Kninska ul. 24", "Osijek", "031202040", "oliva@mail.com", "oliva123");
insert into restoran (naziv,adresa,grad,kontakt_broj,email,lozinka) values ("Lipov Hlad","Trg bana Jelačića 2", "Osijek", "031508811", "lipovhlad@mail.com", "lipovhlad123");
insert into restoran (naziv,adresa,grad,kontakt_broj,email,lozinka) values ("Rustika","Ul. Pavla Pejačevića 32", "Osijek", "031369400", "rustika@mail.com", "rustika123");

insert into korisnik (ime,prezime,email,lozinka,kontakt_broj) values ("Pero", "Perić", "pero.peric@mail.com", "lozinka123", "123456789");
insert into korisnik (ime,prezime,email,lozinka,kontakt_broj) values ("Ivan", "Ivanić", "ivan.ivanic@mail.com", "lozinka123", "987654321");

insert into adresa_dostave(ulica, kucni_broj, grad, korisnik) values ("Sjenjak", "1", "Osijek", 1);
insert into adresa_dostave(ulica, kucni_broj, grad, korisnik) values ("Vukovarska", "38", "Osijek", 2);

insert into kategorija_jela (naziv) values ("Pizza");
insert into kategorija_jela (naziv) values ("Grill");
insert into kategorija_jela (naziv) values ("Riba");
insert into kategorija_jela (naziv) values ("Odresci");
insert into kategorija_jela (naziv) values ("Deserti");

insert into restoran_kategorija values (1,1);
insert into restoran_kategorija values (1,5);
insert into restoran_kategorija values (2,2);
insert into restoran_kategorija values (2,3);
insert into restoran_kategorija values (2,1);
insert into restoran_kategorija values (3,5);
insert into restoran_kategorija values (3,4);
insert into restoran_kategorija values (3,3);
insert into restoran_kategorija values (4,1);
insert into restoran_kategorija values (4,3);
insert into restoran_kategorija values (4,5);

insert into jelo (naziv, sastojci, cijena, kategorija_jela, restoran) values ("Capricciosa", "rajčica,sir,šunka,gljive", 32, 1, 1);
insert into jelo (naziv, sastojci, cijena, kategorija_jela, restoran) values ("Mexican", "rajčica,sir,suhi vrat,kulen,slanina,jaje,paprika,vrhnje,feferoni", 41, 1,2);
insert into jelo (naziv, sastojci, cijena, kategorija_jela, restoran) values ("Slavonska", "rajčica,sir,šunka,gljive,kulen,slanina,ajvar,jaje,luk,feferoni", 36, 1,1);
insert into jelo (naziv, sastojci, cijena, kategorija_jela, restoran) values ("Vegetariana", "rajčica,sir,gljive,svježa rajčica,svježa paprika,kukuruz,maslina", 32, 1,4);
insert into jelo (naziv, sastojci, cijena, kategorija_jela, restoran) values ("Bakine palačinke", "palačinke s domaćim džemom od plavih šljiva i kajmakom", 19, 5,4);
insert into jelo (naziv, sastojci, cijena, kategorija_jela, restoran) values ("Palačinke karaka", "palačinke sa sladoledom i toplim preljevom od višanja", 25, 5,1);
insert into jelo (naziv, sastojci, cijena, kategorija_jela, restoran) values ("Palačinke po izboru gosta", "čokolada, marmelada, orasi", 16, 5,3);
insert into jelo (naziv, sastojci, cijena, kategorija_jela, restoran) values ("Biftek na žaru", "biftek odrezak 250g, krumpir pire", 105, 2,2);
insert into jelo (naziv, sastojci, cijena, kategorija_jela, restoran) values ("Biftek s gljivama", "biftek 250g, gljive, krumpir pire, sezonsko povrće", 115, 2,2);
insert into jelo (naziv, sastojci, cijena, kategorija_jela, restoran) values ("Pepper Steak", "biftek 250g, umak od zelenog papra, restani krumpir, sezonsko povrće", 115, 2,2);
insert into jelo (naziv, sastojci, cijena, kategorija_jela, restoran) values ("Lignje frigane", "lignje, pommes, tartar umak", 61, 3,2);
insert into jelo (naziv, sastojci, cijena, kategorija_jela, restoran) values ("Pastrva na žaru", "pastrva, kuhani krumpir, blitva, trščanski umak", 54, 3,3);
insert into jelo (naziv, sastojci, cijena, kategorija_jela, restoran) values ("Girice", "pommes, limun, lepinjice", 23, 3,4);
insert into jelo (naziv, sastojci, cijena, kategorija_jela, restoran) values ("Bečki odrezak", "pommes ili riža, tartar, lepinjice", 32, 4,3);
insert into jelo (naziv, sastojci, cijena, kategorija_jela, restoran) values ("Zagrebački odrezak", "sir, šunka, pommes ili riža, tartar, lepinjice", 38, 4,3);
insert into jelo (naziv, sastojci, cijena, kategorija_jela, restoran) values ("Slavonski odrezak", "gljive, sir, šunka, pommes, tartar", 39, 4,3);