cd servidor_central
ant compile
ant jar
cd ..
cd servidor_web
ant
cd ..
cp -r servidor_central/src/presentacion/img dist
cp -r servidor_central/src/presentacion/mp3 dist
cp servidor_central/espotify_properties dist
cp servidor_central/espotify_db dist
