ANT_HOME=/ens/apps/netbeans-8.0/extide/ant
ANT_OPS="-Xms256M -Xmx512M"
PATH=$PATH:$HOME/bin:$ANT_HOME/bin
export ANT_HOME ANT_OPS PATH
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
cp servidor_web/espotifyweb_properties dist
