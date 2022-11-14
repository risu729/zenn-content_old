#!/bin/bash

# Install libraries
sudo dpkg --add-architecture armhf
sudo apt update
sudo apt upgrade -y
sudo apt install build-essential cmake xrdp ubuntu-desktop wine -y

# Open port
sudo iptables -I INPUT 5 -p udp --dport 19132 -j ACCEPT
sudo iptables -I INPUT 5 -p tcp --dport 3389 -j ACCEPT
sudo /etc/init.d/netfilter-persistent save
sudo /etc/init.d/netfilter-persistent reload

# Change password for rdp
sudo passwd ubuntu

# Install box64
cd ~
git clone https://github.com/ptitSeb/box64
cd box64
mkdir build
cd build
cmake .. -DARM_DYNAREC=ON -DCMAKE_BUILD_TYPE=RelWithDebInfo
make -j$(nproc)
sudo make install
sudo systemctl restart systemd-binfmt

# Install bds
mkdir bds
cd bds
wget https://minecraft.azureedge.net/bin-win/bedrock-server-1.19.22.01.zip
unzip bedrock-server-1.19.22.01.zip
rm bedrock-server-1.19.22.01.zip

# Install liteloaderBDS
wget https://github.com/LiteLDev/LiteLoaderBDS/releases/download/2.6.1/LiteLoader-2.6.1.zip
unzip LiteLoader-2.6.1.zip
rm LiteLoader-2.6.1.zip
rm plugins/LLMoney.dll

# Install trapdoor
wget https://github.com/hhhxiao/trapdoor-ll/releases/download/0.18.0-1.19.22.01/release.zip
unzip release.zip
rm release.zip
rsync -a out/plugins/ plugins/
rm -r out

# Run in terminal on rdp
wine LLPeEditor.exe
wine bedrock_server_mod.exe

# Client resource pack
https://github.com/OEOTYAN/Trapdoor-CUI/releases/download/v5.0/Trapdoor-CUIv5.0.mcpack