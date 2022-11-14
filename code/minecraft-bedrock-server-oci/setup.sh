#!/bin/bash

# Install libraries
sudo apt update
sudo apt upgrade -y
sudo apt install build-essential cmake unzip -y

# Open port
sudo iptables -I INPUT 5 -p udp --dport 19132 -j ACCEPT
sudo /etc/init.d/netfilter-persistent save
sudo /etc/init.d/netfilter-persistent reload

# Install openssl
cd ~
wget https://www.openssl.org/source/openssl-1.1.1q.tar.gz
tar xvf openssl-1.1.1q.tar.gz
rm openssl-1.1.1q.tar.gz
cd openssl-1.1.1q
./config --prefix=/opt/openssl-1.1.1
make
sudo make install
sudo sed -i '1i/opt/openssl-1.1.1/lib' /etc/ld.so.conf
sudo ldconfig

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
cd ~
mkdir bds
cd bds
wget https://minecraft.azureedge.net/bin-linux/bedrock-server-1.19.30.04.zip
unzip bedrock-server-1.19.30.04.zip
rm bedrock-server-1.19.30.04.zip