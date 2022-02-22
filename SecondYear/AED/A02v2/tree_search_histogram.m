clc
close all
clear

filename = "tree_creation.txt";
f = fopen(filename);
count = 1;
target = 100000;
tempos = zeros(1, 100);

while 1
    tline = fgetl(f);
    if ~ischar(tline), break, end
    data = split(tline);
    if (str2double(data{1,1}) == target)
        tempos(count) = round(str2double(data{2,1}),3);
        count = count+1;
    end
end

histogram(tempos, 150, "Facecolor", "r")
title("Tree Creation 100 Experiments of 100000 People")
xlabel("Execution Time")
ylabel("Number of Occurrences")
legend("all indices")
fclose(f);