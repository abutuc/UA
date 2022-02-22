clear
clc
close all

fn = "tree_creation.txt";
f = fopen(fn);
count = 1;
pessoas = zeros(1, 1900);
tempos = zeros(1, 1900);
while 1
    tline = fgetl(f);
    if ~ischar(tline), break, end
    data = split(tline);
    pessoas(count) = str2double(data{1,1});
    tempos(count) = str2double(data{2,1});
    count = count+1;
end
loglog(pessoas, tempos, ".r");
legend("all indices");
xlabel("Number of People")
ylabel("Execution Time")
legend('Location', 'northwest');
title("Tree Creation Time")
fclose(f);