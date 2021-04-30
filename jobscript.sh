#!/bin/bash
echo "Bienvenido/a al planeta $planeta"
if [ "$agente" = "true" ]
then
	echo "Preparece para la misión agente X."
else
	echo "Disfruta el planeta $planeta humano $nombre."
fi
echo "..."
sleep 10
echo "Suerte"