matrix 13x13

0 1 1 0 0 0 0 0 0 0 0 0 0
1 0 1 0 0 1 1 0 0 0 0 0 0 
1 1 0 1 1 1 0 0 0 0 0 0 0
0 0 1 0 1 0 0 0 0 0 0 1 0
0 0 1 1 0 1 0 1 0 0 1 1 0
0 1 1 0 1 0 1 1 0 0 0 0 0 
0 1 0 0 0 1 0 1 1 0 0 0 0  
0 0 0 0 1 1 1 0 1 1 1 0 0 
0 0 0 0 0 0 1 1 0 1 0 0 0 
0 0 0 0 0 0 0 1 1 0 1 0 1
0 0 0 0 1 0 0 1 0 1 0 1 1
0 0 0 1 1 0 0 0 0 0 1 0 1
0 0 0 0 0 0 0 0 0 1 1 1 0

CreateGame game
CreateBoard board
CreateField f1 hole
CreateField f2 stable
CreateField f3 unstable 
CreateField f4 hole
CreateField f5 stable
CreateField f6 hole
CreateField f7 unstable
CreateField f8 stable
CreateField f9 hole
CreateField f10 stable
CreateField f11 hole
CreateField f12 stable
CreateField f13 unstable
CreateItem s shovel 2
CreateItem r1 gun 2
CreateItem r2 flare 2
CreateItem r3 cartridge 2
FieldAddItem shovel f8 2 
FieldAddItem gun f10 2
FieldAddItem flare f5 2
FieldAddItem cartridge f13 2
CreateCharacter e1 eskimo
CreateCharacter k1 explorer                
CreateCharacter k2 explorer             
CreateCharacter m1 polarbear          
AddCharacter e1 f3
AddCharacter k1 f2
AddCharacter k2 f7
AddCharacter m1 f12
SetCapacity f3 2
SetCapacity f7 2
SetCapacity f13 2
SetLayer f1 1 
SetLayer f2 1 
SetLayer f3 1
SetLayer f4 1
SetLayer f5 1
SetLayer f6 1 
SetLayer f7 1 
SetLayer f8 1
SetLayer f9 1
SetLayer f10 1 
SetLayer f11 1 
SetLayer f12 1 
SetLayer f13 1 
SetCapacity f3 1
MoveCharacter k1 f3 
list k1 test1out.txt
list e1 test1out.txt


