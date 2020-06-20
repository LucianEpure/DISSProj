# DISSProj
Project for DISS class 

Ar trebui sa mearga daca rulati clasa cu main. Faceti ce am scris mai jos la Pentru db ca sa nu crape.

Pentru db:

- Trebuie sa aveti MySQL. 
- Daca aveti username "root" si parola "1234" e totu ok, daca nu, trebuie modificat in application.properties din folderul resources cu usernameul si parola voastre. Cred ca ar fi bine sa si punem fileu ala in .gitignore ca sa nu ii mai tot dam push de la unu la altu. 
- Creati o baza de date in MySQL numita "company"

Cand rulati clasa cu main ar trebui sa se conecteze la db si sa faca tabelele de User si Role. O sa creeze si 2 roluri de ADMIN si de HR si 2 useri "Admin1" si "Gigel", amandoi au parola 1234. Gasiti codu asta in clasa Bootstrap din pachetu application.

Momentan nu am adaugat niciun algoritm de criptat parola din db deci totul apare in plain text acum "O nu!!!"(probabil ziceti acum socati cu totii). Este ceva nebunie in spring dar o sa fie mai complex de configurat dar probabil o sa adaug in curand daca e musai :) .

Momentan daca intrati la http://localhost:8080/greeting dupa ce ati pornit aplicatia si v-a facut deploy o sa va arate un JSON returnat din app.

lala