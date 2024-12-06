# CISCO příkazy - scénáře

Typové scénáře nastavení pro CISCO **switch** a **router**.

## Základní nastavení switche/routeru

Nastavení názvu zařízení, uvítacího baneru, hesla do privilegovaného režimu a do konsole.

```console
Switch>enable
Switch#configure terminal
Switch(config)#hostname S2
S2(config)#banner motd "Hello. Restricted area."
S2(config)#enable secret cisco
S2(config)#line console 0
S2(config-line)#password cisco
S2(config-line)#login
S2(config-line)#exit
```

## SSH + RSA

Vygenerování RSA klíče pro SSH komunikaci, vytvoření domény, nastavení SSH a uživatelského účtu.

```console
S2(config)#ip domain-name lab.cz
S2(config)#crypto key generate rsa general-keys modulus 1024
S2(config)#ip ssh version 2
S2(config)#ip ssh time-out 60
S2(config)#ip ssh authentication-retries 2
S2(config)#username mik privilege 15 secret cisco
```

## VTY + SSH

Nastavení SSH pro VTY.

```console
S2(config)#line vty 0 4
S2(config-line)#login local
S2(config-line)#transport input ssh
S2(config-line)#exit
S2(config)#service password-encryption
```

## IP adresa + GATEWAY

Nastavení brány a IP adresy pro default VLAN.

```console
S2(config)#ip default-gateway 192.168.2.1
S2(config)#interface vlan 1
S2(config-if)#ip address 192.168.2.2 255.255.255.0
S2(config-if)#no shutdown
S2(config-if)#end
S2#show ip interface brief
S2#copy running-config startup-config
```

## PC

```console
C:\>ssh -l mik 192.168.2.2
```

## VLAN

```console
S34(config)#vlan 30
S34(config-vlan)#name VLAN30
S34(config-vlan)#exit
S34(config)#vlan 40
S34(config-vlan)#name VLAN40
S34(config)#vlan 99
S34(config-vlan)#name Management
S34(config-vlan)#exit
```

## VLAN TO INTERFACES/PORTS

```console
S34(config)#interface range fastEthernet 0/1 - 12
S34(config-if-range)#switchport mode access
S34(config-if-range)#switchport access vlan 30
S34(config-if-range)#interface range fastEthernet 0/13 - 24
S34(config-if-range)#switchport mode access
S34(config-if-range)#switchport access vlan 40
S34(config-if-range)#end
S34#show vlan brief
```

## MANAGEMENT VLAN 99

```console
S34(config)#ip default-gateway 192.168.99.1
S34(config)#interface vlan 99
S34(config-if)#ip address 192.168.99end.2 255.255.255.0
```

## TRUNK

```console
S34(config)#interface gigabitEthernet 0/1
S34(config-if)#switchport mode trunk
S34(config-if)#switchport trunk allowed vlan 30,40,99
S34(config-if)#no shutdown
S34(config-if)#end
S34#show running-config
```

## ROUTER TRUNK SUBINTERFACES

```console
R2(config)#interface gigabitEthernet 0/0/0
R2(config-if)#description Trunk to S34
R2(config-if)#no shutdown
R2(config-if)#exit
R2(config)#interface gigabitEthernet 0/0/0.30
R2(config-subif)#description VLAN 30
R2(config-subif)#encapsulation dot1Q 30
R2(config-subif)#ip address 192.168.3.1 255.255.255.0
R2(config-subif)#exit
R2(config)#interface gigabitEthernet 0/0/0.40
R2(config-subif)#description VLAN 40
R2(config-subif)#encapsulation dot1Q 40
R2(config-subif)#ip address 192.168.4.1 255.255.255.0
R2(config-subif)#exit
R2(config)#interface gigabitEthernet 0/0/0.99
R2(config-subif)#description VLAN 99
R2(config-subif)#encapsulation dot1Q 99
R2(config-subif)#ip address 192.168.99.1 255.255.255.0
R2(config-subif)#exit
R2(config)#
```

## STATIC ROUTES

```console
R2(config)#ip route 192.168.1.0 255.255.255.0 192.168.0.1
R2(config)#ip route 192.168.2.0 255.255.255.0 192.168.0.1
R2(config)#exit
R2#show ip route
```

## SHOW

```console
R1#show interfaces
R1#show ip interface brief
R1#show ip interface g0/0/0
R1#show ip interface g0/0/0 | include address
R1#show ip route
R1#show ip ssh
R1#show running-config
R1#show running-config | include interface
R1#show running-config | section interface
R1#show running-config | i pass
R1#show version
R1#show vlan
R1#show cdp neighbors
R1#show arp
R1#show protocols
R1#show mac-address-table
```
